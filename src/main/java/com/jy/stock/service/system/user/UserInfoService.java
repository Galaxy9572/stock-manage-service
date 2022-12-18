package com.jy.stock.service.system.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.system.user.UserInfo;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import com.jy.stock.pojo.request.system.user.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.system.user.QueryUserInfoReq;
import com.jy.stock.pojo.request.system.user.UserLoginReq;

import javax.servlet.http.HttpSession;
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
}
