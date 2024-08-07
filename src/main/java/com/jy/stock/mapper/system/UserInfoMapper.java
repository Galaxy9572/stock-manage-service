package com.jy.stock.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.system.UserInfo;
import com.jy.stock.model.dto.system.UserInfoDTO;
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