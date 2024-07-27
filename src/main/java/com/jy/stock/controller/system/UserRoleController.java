package com.jy.stock.controller.system;

import com.jy.stock.common.response.CodeDescVO;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.service.system.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户角色控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/system/user/role")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 获取所有角色类型
     *
     * @return List<UserRoleEnumVO>
     */
    @GetMapping("/all")
    public HttpResult<List<CodeDescVO>> listAllRoles() {
        return HttpResult.success(UserRoleEnum.listAllRoles());
    }

}
