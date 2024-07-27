package com.jy.stock.model.request.info;

import com.jy.stock.common.validate.annotation.info.ValidateEmail;
import com.jy.stock.common.validate.annotation.info.ValidateQQ;
import com.jy.stock.common.validate.annotation.info.ValidateWechat;
import com.jy.stock.model.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.NotBlank;

/**
 * 供应商信息
 *
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddModifySupplierInfoReq extends AddModifyRequest {

    /**
     * 客户名称
     */
    @NotBlank(message = "{supplier.name.cannot.empty}")
    private String supplierName;

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
     * 区
     */
    @NotBlank(message = "district.cannot.empty")
    private String district;

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
     * 备注
     */
    private String memo;
}