package com.jy.stock.controller.user;

import com.jy.stock.service.user.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户信息控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

}
