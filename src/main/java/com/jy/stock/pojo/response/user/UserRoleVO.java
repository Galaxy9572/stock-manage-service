package com.jy.stock.pojo.response.user;

import lombok.Data;

import java.util.Date;

/**
 * @author liaojunyao
 */
@Data
public class UserRoleVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}