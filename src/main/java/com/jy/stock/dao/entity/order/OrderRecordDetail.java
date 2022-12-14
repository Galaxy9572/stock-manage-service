package com.jy.stock.dao.entity.order;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liaojunyao
 */
@Data
@TableName(value = "order_record_detail")
public class OrderRecordDetail {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 供应商ID
     */
    private Long supplierId;

    /**
     * 客户ID
     */
    private Long customerId;

    /**
     * 创建人ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 更新人ID
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateUserId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean logicDelete;
}