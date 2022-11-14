package com.jy.stock.pojo.dto.user;

import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author liaojunyao
 */
@Data
public class UserInfoDTO {
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

    /**
     * 逻辑删除
     */
    private Boolean logicDelete;
}