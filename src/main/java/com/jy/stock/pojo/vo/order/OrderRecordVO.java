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
public class OrderRecordVO extends BaseVO {

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
    private SupplierInfoVO supplier;

    /**
     * 客户
     */
    private SupplierInfoVO customer;

}