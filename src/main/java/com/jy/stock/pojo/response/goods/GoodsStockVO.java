package com.jy.stock.pojo.response.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品库存
 * @author liaojunyao
 */
@Data
public class GoodsStockVO {
    /**
     * 商品库存ID
     */
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 批发价
     */
    private BigDecimal wholesalePrice;

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
     * 创建用户ID
     */
    private Long createUserId;

    /**
     * 更新用户ID
     */
    private Long updateUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}