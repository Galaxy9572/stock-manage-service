package com.jy.stock.pojo.response.order;

import com.jy.stock.pojo.response.info.SupplierInfoVO;
import com.jy.stock.pojo.response.system.UserInfoVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liaojunyao
 */
@Data
public class OrderRecordDetailVO {
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
    private SupplierInfoVO supplier;

    /**
     * 客户
     */
    private SupplierInfoVO customer;

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