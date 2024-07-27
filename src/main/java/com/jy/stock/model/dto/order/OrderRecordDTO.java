package com.jy.stock.model.dto.order;

import com.jy.stock.model.dto.info.SupplierInfoDTO;
import com.jy.stock.model.dto.system.UserInfoDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author liaojunyao
 */
@Data
public class OrderRecordDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

    /**
     * 支付方式
     */
    private String paymentMethod;

    /**
     * 备注
     */
    private String memo;

    /**
     * 供应商
     */
    private SupplierInfoDTO supplier;

    /**
     * 客户
     */
    private SupplierInfoDTO customer;

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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    private Boolean logicDelete;
}