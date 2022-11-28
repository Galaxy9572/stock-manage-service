package com.jy.stock.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.exception.BusinessException;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.ContextHolder;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.common.util.PageUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.dao.mapper.user.UserInfoMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.pojo.request.user.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.user.QueryUserInfoReq;
import com.jy.stock.pojo.request.user.UserLoginReq;
import com.jy.stock.service.user.UserInfoService;
import com.jy.stock.service.user.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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
        session.setAttribute("token", token);
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

        UserInfo userInfo = new UserInfo();
        BeanCopyUtils.copy(request, userInfo);
        userInfo.setId(null);
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
        queryWrapper.eq(UserInfo::getUserName, request.getId());
        long count = count(queryWrapper);
        AssertUtils.isTrue(count > 0, "user.not.exist");

        UserInfo userInfo = new UserInfo();
        BeanCopyUtils.copy(request, userInfo);
        boolean isSuccess = updateById(userInfo);
        userRoleService.addModifyUserRoles(request.getId(), request.getRoles());
        if (isSuccess) {
            return getUserInfoById(userInfo.getId());
        } else {
            throw BusinessException.of("operate.failed");
        }
    }

    @Override
    public PageDTO<UserInfoDTO> listUserInfo(QueryUserInfoReq request) {
        Page<UserInfo> page = new Page<>(request.getPageNo(), request.getPageSize());
        UserInfoDTO param = new UserInfoDTO();
        param.setUserName(request.getUserName());
        param.setRoles(request.getRoles());
        IPage<UserInfoDTO> dtoPage = baseMapper.listUserInfo(page, param);
        return PageUtils.toPageDTO(dtoPage);
    }

    @Override
    public UserInfoDTO getUserInfoById(Long userId) {
        UserInfoDTO userInfo = baseMapper.getUserInfoById(userId);
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        HttpSession session = ContextHolder.currentHttpRequest().getSession();
        String token = (String) session.getAttribute("token");
        userInfo.setToken(token);
        return userInfo;
    }

    @Override
    public UserInfoDTO getUserInfoByName(String userName) {
        UserInfoDTO userInfo = baseMapper.getUserInfoByName(userName);
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        HttpSession session = ContextHolder.currentHttpRequest().getSession();
        String token = (String) session.getAttribute("token");
        userInfo.setToken(token);
        return userInfo;
    }

    @Override
    public Class<UserInfoDTO> getDtoClass() {
        return UserInfoDTO.class;
    }
}
