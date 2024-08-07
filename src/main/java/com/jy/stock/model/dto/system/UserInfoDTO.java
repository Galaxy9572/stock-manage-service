package com.jy.stock.model.dto.system;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 备注
     */
    private String memo;

    /**
     * 密码
     */
    private String encryptedPassword;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 用户角色
     */
    private List<String> roles;

    /**
     * token
     */
    private String token;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    private Boolean logicDelete;
}