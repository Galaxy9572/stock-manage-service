package com.jy.stock.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.system.UserInfo;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.system.UserInfoDTO;
import com.jy.stock.model.request.system.AddModifyUserInfoReq;
import com.jy.stock.model.request.system.QueryUserInfoReq;
import com.jy.stock.model.request.system.UserLoginReq;

import jakarta.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Map;

public interface UserInfoService extends IService<UserInfo>{

    UserInfoDTO login(HttpSession session, UserLoginReq loginReq);

    UserInfoDTO addUser(AddModifyUserInfoReq request);

    UserInfoDTO updateUser(AddModifyUserInfoReq request);

    boolean deleteUser(Long id);

    PageDTO<UserInfoDTO> listUserInfoByPage(QueryUserInfoReq request);

    Map<Long, UserInfoDTO> batchListUserInfo(Collection<Long> userIds);

    UserInfoDTO getUserInfoById(Long userId);

    UserInfoDTO getUserInfoByName(String userName);

    long countAllUsers();
}
