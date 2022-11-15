package com.jy.stock.service.user.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.dao.mapper.user.UserInfoMapper;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.pojo.request.user.UserLoginReq;
import com.jy.stock.service.user.UserInfoService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 用户信息服务
 * @author liaojunyao
 */
@Service
public class UserInfoServiceImpl extends EnhancedServiceImpl<UserInfoMapper, UserInfo, UserInfoDTO> implements UserInfoService {

    @Override
    public UserInfoDTO login(HttpSession session, UserLoginReq loginReq) {
        UserInfoDTO userInfo = getUserInfoByName(loginReq.getUserName());
        AssertUtils.isNotNull(userInfo, "user.not.exist");
        String encryptedPassword = HashUtils.sha256(loginReq.getPassword() + userInfo.getSalt());
        AssertUtils.equal(encryptedPassword, userInfo.getEncryptedPassword(), "nick.or.password.wrong");
        session.setAttribute("token", HashUtils.randomUuid());
        return userInfo;
    }

    @Override
    public UserInfoDTO getUserInfoById(Long userId){
        return baseMapper.getUserInfoById(userId);
    }

    @Override
    public UserInfoDTO getUserInfoByName(String userName) {
        return baseMapper.getUserInfoByName(userName);
    }

    @Override
    public Class<UserInfoDTO> getDtoClass() {
        return UserInfoDTO.class;
    }
}
