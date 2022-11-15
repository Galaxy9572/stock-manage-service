package com.jy.stock.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.user.UserRole;
import com.jy.stock.pojo.dto.user.UserRoleDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    int batchInsert(@Param("list") List<UserRole> list);

    List<UserRoleDTO> selectByUserId(@Param("userId") Long userId);
}