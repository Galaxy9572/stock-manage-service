package com.jy.stock.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.user.UserRole;

import java.util.List;
public interface UserRoleService extends IService<UserRole>{


    int batchInsert(List<UserRole> list);

}
