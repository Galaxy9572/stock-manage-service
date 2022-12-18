package com.jy.stock.service.system.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.exception.BusinessException;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.common.util.PageUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.constants.system.user.UserConstants;
import com.jy.stock.dao.entity.system.user.UserInfo;
import com.jy.stock.dao.mapper.user.UserInfoMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import com.jy.stock.pojo.request.system.user.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.system.user.QueryUserInfoReq;
import com.jy.stock.pojo.request.system.user.UserLoginReq;
import com.jy.stock.service.system.user.UserInfoService;
import com.jy.stock.service.system.user.UserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息服务
 *
 * @author liaojunyao
 */
@Service
public class UserInfoServiceImpl extends EnhancedServiceImpl<UserInfoMapper, UserInfo, UserInfoDTO> implements UserInfoService {

    @Resource
    private UserRoleService userRoleService;

    @Override
    public UserInfoDTO login(HttpSession session, UserLoginReq loginReq) {
        UserInfoDTO userInfo = getUserInfoByName(loginReq.getUserName());
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        String encryptedPassword = HashUtils.sha256(loginReq.getPassword() + userInfo.getSalt());
        AssertUtils.equal(encryptedPassword, userInfo.getEncryptedPassword(), "nick.or.password.wrong");
        String token = HashUtils.randomUuid();
        session.setAttribute(UserConstants.TOKEN, token);
        session.setAttribute(UserConstants.USER_ID, userInfo.getId());
        userInfo.setToken(token);
        return userInfo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDTO addUser(AddModifyUserInfoReq request) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getUserName, request.getUserName());
        long count = count(queryWrapper);
        AssertUtils.isTrue(count == 0, "user.already.registered");

        String salt = HashUtils.randomSalt();
        String encryptedPassword = HashUtils.sha256(request.getPassword() + salt);
        UserInfo userInfo = new UserInfo();
        BeanCopyUtils.copy(request, userInfo);
        userInfo.setId(null);
        userInfo.setSalt(salt);
        userInfo.setEncryptedPassword(encryptedPassword);
        boolean isSuccess = save(userInfo);
        userRoleService.addModifyUserRoles(userInfo.getId(), request.getRoles());
        if (isSuccess) {
            return getUserInfoById(userInfo.getId());
        } else {
            throw BusinessException.of("operate.failed");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserInfoDTO updateUser(AddModifyUserInfoReq request) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getId, request.getId());
        long count = count(queryWrapper);
        AssertUtils.isTrue(count > 0, "user.not.exist");

        UserInfo userInfo = new UserInfo();
        BeanCopyUtils.copy(request, userInfo);
        if(StringUtils.isNotEmpty(request.getPassword())){
            String salt = HashUtils.randomSalt();
            String encryptedPassword = HashUtils.sha256(request.getPassword() + salt);
            userInfo.setSalt(salt);
            userInfo.setEncryptedPassword(encryptedPassword);
        }
        boolean isSuccess = updateById(userInfo);
        userRoleService.addModifyUserRoles(request.getId(), request.getRoles());
        if (isSuccess) {
            return getUserInfoById(userInfo.getId());
        } else {
            throw BusinessException.of("operate.failed");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(Long id) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserInfo::getId, id);
        long count = count(queryWrapper);
        AssertUtils.isTrue(count > 0, "user.not.exist");
        boolean isUserDeleted = removeById(id);
        boolean isRoleDeleted = userRoleService.deleteUserRolesByUserId(id);
        return isUserDeleted && isRoleDeleted;
    }

    @Override
    public PageDTO<UserInfoDTO> listUserInfoByPage(QueryUserInfoReq request) {
        Page<UserInfo> page = new Page<>(request.getPageNo(), request.getPageSize());
        UserInfoDTO param = new UserInfoDTO();
        param.setUserName(request.getUserName());
        param.setRoles(request.getRoles());
        IPage<UserInfoDTO> dtoPage = baseMapper.listUserInfoByPage(page, param);
        return PageUtils.toPageDTO(dtoPage);
    }

    @Override
    public Map<Long, UserInfoDTO> batchListUserInfo(Collection<Long> userIds) {
        if(CollectionUtils.isEmpty(userIds)) {
            return new HashMap<>(0);
        }
        return baseMapper.batchListUserInfoByUserIds(userIds);
    }

    @Override
    public UserInfoDTO getUserInfoById(Long userId) {
        UserInfoDTO userInfo = baseMapper.getUserInfoById(userId);
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        return userInfo;
    }

    @Override
    public UserInfoDTO getUserInfoByName(String userName) {
        UserInfoDTO userInfo = baseMapper.getUserInfoByName(userName);
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        return userInfo;
    }

    @Override
    public Class<UserInfoDTO> getDtoClass() {
        return UserInfoDTO.class;
    }
}
