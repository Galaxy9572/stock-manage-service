package com.jy.stock.dao.entity.goods;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 商品库存
 * @author liaojunyao
 */
@Data
@TableName(value = "goods_stock")
public class GoodsStock {
    /**
     * 商品库存ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 初始库存数量
     */
    private Long initStockNum;

    /**
     * 最低库存数量
     */
    private Long minStockNum;

    /**
     * 最高库存数量
     */
    private Long maxStockNum;

    /**
     * 当前库存数量
     */
    private Long currentStockNum;

    /**
     * 是否允许库存告警
     */
    private Boolean allowStockWarning;

    /**
     * 创建用户ID
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUserId;

    /**
     * 更新用户ID
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