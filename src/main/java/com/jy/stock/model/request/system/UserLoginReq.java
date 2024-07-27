package com.jy.stock.model.request.system;

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
