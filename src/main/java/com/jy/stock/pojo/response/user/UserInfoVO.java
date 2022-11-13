package com.jy.stock.pojo.response.user;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author liaojunyao
 */
@Data
public class UserInfoVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String encryptedPassword;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}