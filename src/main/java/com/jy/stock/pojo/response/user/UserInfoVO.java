package com.jy.stock.pojo.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户信息
 * @author liaojunyao
 */
@Data
public class UserInfoVO {
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}