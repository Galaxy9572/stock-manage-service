package com.jy.stock.pojo.response.order;

import com.jy.stock.pojo.response.info.supplier.SupplierInfoVO;
import com.jy.stock.pojo.response.system.user.UserInfoVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liaojunyao
 */
@Data
public class OrderRecordVO {
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