package com.jy.stock.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.system.UserRole;
import com.jy.stock.model.dto.system.UserRoleDTO;

import java.util.List;
public interface UserRoleService extends IService<UserRole>{


    List<UserRoleDTO> addModifyUserRoles(Long userId, List<String> roles);

    boolean deleteUserRolesByUserId(Long userId);

    List<UserRoleDTO> listByUserId(Long userId);
}
