package com.jy.stock.pojo.dto.info;

import com.jy.stock.pojo.dto.system.UserInfoDTO;
import lombok.Data;

import java.util.Date;

/**
    * 门店信息
 * @author liaojunyao
 */
@Data
public class ShopInfoDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 门店名称
     */
    private String shopName;

    /**
     * 是否为默认门店
     */
    private Boolean defaultShop;

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
     * 创建人
     */
    private UserInfoDTO createUser;

    /**
     * 更新人
     */
    private UserInfoDTO updateUser;

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
    private Boolean logicDelete;
}