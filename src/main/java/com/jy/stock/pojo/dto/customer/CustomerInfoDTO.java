package com.jy.stock.pojo.dto.customer;

import com.baomidou.mybatisplus.annotation.*;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户信息
 * @author liaojunyao
 */
@Data
public class CustomerInfoDTO {
    /**
     * 主键
     */
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
     * 开户行
     */
    private String bankName;

    /**
     * 银行卡号
     */
    private String bankCardId;

    /**
     * 纳税人识别号
     */
    private String taxpayerId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private UserInfoDTO createUser;

    /**
     * 更新人
     */
    private UserInfoDTO updateUser;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean logicDelete;
}