package com.jy.stock.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    int batchInsert(@Param("list") List<UserInfo> list);

    UserInfoDTO getUserInfoById(@Param("userId") Long userId);

    UserInfoDTO getUserInfoByName(@Param("userName") String userName);

}