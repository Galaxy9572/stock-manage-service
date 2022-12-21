package com.jy.stock.pojo.vo.order;

import com.jy.stock.pojo.vo.BaseVO;
import com.jy.stock.pojo.vo.info.SupplierInfoVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class OrderRecordDetailVO extends BaseVO {

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
    private SupplierInfoVO supplier;

    /**
     * 客户
     */
    private SupplierInfoVO customer;

}