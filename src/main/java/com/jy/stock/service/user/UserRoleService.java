package com.jy.stock.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.user.UserRole;
import com.jy.stock.pojo.dto.user.UserRoleDTO;

import java.util.List;
public interface UserRoleService extends IService<UserRole>{


    List<UserRoleDTO> addModifyUserRoles(Long userId, List<String> roles);

    int batchInsert(List<UserRole> list);

}
