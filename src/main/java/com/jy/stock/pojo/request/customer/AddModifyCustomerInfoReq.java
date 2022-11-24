package com.jy.stock.pojo.request.customer;

import com.jy.stock.common.validate.annotation.ValidateEmail;
import com.jy.stock.common.validate.annotation.ValidateQQ;
import com.jy.stock.common.validate.annotation.ValidateWechat;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * 客户信息
 *
 * @author liaojunyao
 */
@Data
public class AddModifyCustomerInfoReq {
    /**
     * 主键
     */
    private Long id;

    /**
     * 客户名称
     */
    @NotBlank(message = "{customer.name.cannot.empty}")
    private String customerName;

    /**
     * 联系人
     */
    @NotBlank(message = "{contact.person.cannot.empty}")
    private String contactPerson;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 电子邮箱
     */
    @ValidateEmail
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * QQ号
     */
    @ValidateQQ
    private String qq;

    /**
     * 微信号
     */
    @ValidateWechat
    private String wechat;

    /**
     * 国家
     */
    @NotBlank(message = "{country.cannot.empty}")
    private String country;

    /**
     * 州、省
     */
    @NotBlank(message = "{state.cannot.empty}")
    private String state;

    /**
     * 市
     */
    @NotBlank(message = "{city.cannot.empty}")
    private String city;

    /**
     * 地址
     */
    @NotBlank(message = "{address.cannot.empty}")
    private String address;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 初始应收款
     */
    @DecimalMin(value = "0.00", message = "{init.accounts.receivable.invalid}")
    private BigDecimal initAccountsReceivable;

    /**
     * 当前应收款
     */
    @DecimalMin(value = "0.00", message = "{current.accounts.receivable.invalid}")
    private BigDecimal currentAccountsReceivable;

    /**
     * 备注
     */
    private String memo;
}