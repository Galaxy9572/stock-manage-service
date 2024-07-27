package com.jy.stock.model.dto.info;

import com.jy.stock.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
    * 门店信息
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WarehouseInfoDTO extends BaseDTO {

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String phone;

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

}