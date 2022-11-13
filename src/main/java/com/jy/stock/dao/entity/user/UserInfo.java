package com.jy.stock.dao.entity.user;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author liaojunyao
 */
@Data
@TableName(value = "user_info")
public class UserInfo {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
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
    @TableLogic
    private Boolean logicDelete;
}