package com.jy.stock.service.system.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.system.user.UserRole;
import com.jy.stock.pojo.dto.system.user.UserRoleDTO;

import java.util.List;
public interface UserRoleService extends IService<UserRole>{


    List<UserRoleDTO> addModifyUserRoles(Long userId, List<String> roles);

    boolean deleteUserRolesByUserId(Long userId);

    List<UserRoleDTO> listByUserId(Long userId);
}
