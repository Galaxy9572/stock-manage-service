package com.jy.stock.pojo.request.info;

import com.jy.stock.common.validate.annotation.info.ValidateBankInfo;
import com.jy.stock.pojo.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * 仓库信息
 *
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ValidateBankInfo
public class AddModifyWarehouseInfoReq extends AddModifyRequest {

    /**
     * 仓库名称
     */
    @NotBlank(message = "{warehouse.name.cannot.empty}")
    private String warehouseName;

    /**
     * 联系人
     */
    @NotBlank(message = "{contact.person.cannot.empty}")
    private String contactPerson;

    /**
     * 联系电话
     */
    @NotBlank(message = "{phone.cannot.empty}")
    private String phone;

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
    @NotBlank(message = "{district.cannot.empty}")
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
}