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
public class OrderRecordDetailDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 商品数量
     */
    private BigDecimal amount;

    /**
     * 订单总价
     */
    private BigDecimal totalPrice;

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