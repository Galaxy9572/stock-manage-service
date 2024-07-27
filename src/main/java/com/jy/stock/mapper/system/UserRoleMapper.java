package com.jy.stock.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.model.entity.system.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<String> selectRoleCodesByUserId(@Param("userId") Long userId);
}