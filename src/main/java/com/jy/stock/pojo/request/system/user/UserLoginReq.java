package com.jy.stock.pojo.request.system.user;

import lombok.Data;

/**
 * 登录请求
 * @author liaojunyao
 */
@Data
public class UserLoginReq {

    private String userName;

    private String password;

}
