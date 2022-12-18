package com.jy.stock.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.system.user.UserInfo;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.Map;

/**
 * @author liaojunyao
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfoDTO getUserInfoById(@Param("userId") Long userId);

    UserInfoDTO getUserInfoByName(@Param("userName") String userName);

    IPage<UserInfoDTO> listUserInfoByPage(@Param("page") Page<UserInfo> page, @Param("param") UserInfoDTO param);

    @MapKey("id")
    Map<Long, UserInfoDTO> batchListUserInfoByUserIds(@Param("userIds") Collection<Long> userIds);

}