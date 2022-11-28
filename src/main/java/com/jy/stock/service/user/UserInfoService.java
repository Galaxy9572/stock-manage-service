package com.jy.stock.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.pojo.request.user.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.user.QueryUserInfoReq;
import com.jy.stock.pojo.request.user.UserLoginReq;

import javax.servlet.http.HttpSession;

public interface UserInfoService extends IService<UserInfo>{

    UserInfoDTO login(HttpSession session, UserLoginReq loginReq);

    UserInfoDTO addUser(AddModifyUserInfoReq request);

    UserInfoDTO updateUser(AddModifyUserInfoReq request);

    PageDTO<UserInfoDTO> listUserInfo(QueryUserInfoReq request);

    UserInfoDTO getUserInfoById(Long userId);

    UserInfoDTO getUserInfoByName(String userName);
}
