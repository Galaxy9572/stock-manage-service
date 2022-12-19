package com.jy.stock.pojo.response.info;

import com.jy.stock.pojo.response.system.UserInfoVO;
import lombok.Data;

import java.util.Date;

/**
    * 门店信息
 * @author liaojunyao
 */
@Data
public class WarehouseInfoVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 仓库名称
     */
    private String warehouseName;

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
    private UserInfoVO createUser;

    /**
     * 更新人
     */
    private UserInfoVO updateUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}