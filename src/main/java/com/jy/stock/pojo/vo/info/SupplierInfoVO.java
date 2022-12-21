package com.jy.stock.pojo.vo.info;

import com.jy.stock.pojo.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 供应商信息
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SupplierInfoVO extends BaseVO {

    /**
     * 供应商名称
     */
    private String supplierName;

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
     * 备注
     */
    private String memo;

}