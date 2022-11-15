package com.jy.stock.controller.user;

import com.jy.stock.common.enums.UserRoleEnum;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.pojo.response.user.UserRoleEnumVO;
import com.jy.stock.service.user.UserRoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/user/role")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;

    /**
     * 获取所有角色类型
     * @return List<UserRoleEnumVO>
     */
    @GetMapping("/all")
    public ResponseVO<List<UserRoleEnumVO>> listAllRoles(){
        return ResponseVO.success(UserRoleEnum.listAllRoles());
    }

}
