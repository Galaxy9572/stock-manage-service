package com.jy.stock.model.dto.info;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.jy.stock.model.dto.system.UserInfoDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 供应商信息
 * @author liaojunyao
 */
@Data
public class SupplierInfoDTO {
    /**
     * 主键
     */
    private Long id;

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

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

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