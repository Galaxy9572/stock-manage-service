package com.jy.stock.service.user.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.user.UserRole;
import com.jy.stock.dao.mapper.user.UserRoleMapper;
import com.jy.stock.pojo.dto.user.UserRoleDTO;
import com.jy.stock.service.user.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author liaojunyao
 */
@Service
public class UserRoleServiceImpl extends EnhancedServiceImpl<UserRoleMapper, UserRole, UserRoleDTO> implements UserRoleService{

    @Override
    public int batchInsert(List<UserRole> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<UserRoleDTO> getDtoClass() {
        return UserRoleDTO.class;
    }
}
