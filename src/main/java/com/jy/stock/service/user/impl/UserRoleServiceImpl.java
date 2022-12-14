package com.jy.stock.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.dao.entity.user.UserRole;
import com.jy.stock.dao.mapper.user.UserRoleMapper;
import com.jy.stock.pojo.dto.user.UserRoleDTO;
import com.jy.stock.service.user.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
/**
 * @author liaojunyao
 */
@Service
public class UserRoleServiceImpl extends EnhancedServiceImpl<UserRoleMapper, UserRole, UserRoleDTO> implements UserRoleService{

    @Override
    public List<UserRoleDTO> addModifyUserRoles(Long userId, List<String> roles) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId, userId);
        List<UserRole> dbRoles = list(queryWrapper);
        if (CollectionUtils.isEmpty(roles)) {
            // 全部删除
            if(!CollectionUtils.isEmpty(dbRoles)){
                LambdaUpdateWrapper<UserRole> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper.eq(UserRole::getUserId, userId);
                boolean isSuccess = remove(updateWrapper);
                AssertUtils.isTrue(isSuccess, "operate.failed");
            }
            return new ArrayList<>();
        } else {
            // 修改
            List<String> dbRoleCodes = StreamUtils.mapCollect(dbRoles, UserRole::getRoleCode);
            // 新增的角色
            List<String> newRoleCodes = new ArrayList<>(roles);
            newRoleCodes.removeAll(dbRoleCodes);
            if(!CollectionUtils.isEmpty(newRoleCodes)){
                List<UserRole> newRoles = StreamUtils.mapCollect(newRoleCodes, e -> {
                    UserRole role = new UserRole();
                    role.setUserId(userId);
                    role.setRoleCode(e);
                    return role;
                });
                boolean isSuccess = saveBatch(newRoles);
                AssertUtils.isTrue(isSuccess, "operate.failed");
            }
            // 删除的角色
            List<String> deletedRoleCodes = new ArrayList<>(dbRoleCodes);
            deletedRoleCodes.retainAll(roles);
            if(!CollectionUtils.isEmpty(deletedRoleCodes)){
                LambdaUpdateWrapper<UserRole> wrapper = new LambdaUpdateWrapper<>();
                wrapper.eq(UserRole::getUserId, userId).in(UserRole::getRoleCode, deletedRoleCodes);
                boolean isSuccess = remove(wrapper);
                AssertUtils.isTrue(isSuccess, "operate.failed");
            }
        }
        dbRoles = list(queryWrapper);
        return StreamUtils.mapCollect(dbRoles, this::toDto);
    }

    @Override
    public boolean deleteUserRolesByUserId(Long userId){
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId, userId);
        return remove(wrapper);
    }

    @Override
    public List<UserRoleDTO> listByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId, userId);
        List<UserRole> list = list(wrapper);
        return StreamUtils.mapCollect(list, this::toDto);
    }

    @Override
    public Class<UserRoleDTO> getDtoClass() {
        return UserRoleDTO.class;
    }
}
