package com.jy.stock.dao.entity.customer;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户信息
 * @author liaojunyao
 */
@Data
@TableName(value = "customer_info")
public class CustomerInfo {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * QQ号
     */
    private String qq;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 国家
     */
    private String country;

    /**
     * 州、省
     */
    private String state;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 初始应收款
     */
    private BigDecimal initAccountsReceivable;

    /**
     * 当前应收款
     */
    private BigDecimal currentAccountsReceivable;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 更新人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean logicDelete;
}