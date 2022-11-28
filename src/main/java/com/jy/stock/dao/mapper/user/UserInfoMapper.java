package com.jy.stock.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfoDTO getUserInfoById(@Param("userId") Long userId);

    UserInfoDTO getUserInfoByName(@Param("userName") String userName);

    IPage<UserInfoDTO> listUserInfo(@Param("page") Page<UserInfo> page, @Param("param") UserInfoDTO param);

}