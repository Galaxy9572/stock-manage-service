package com.jy.stock.pojo.dto.goods;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @author liaojunyao
 */
@Data
public class GoodsInfoDTO {

    private Long id;

    /**
     * 品名
     */
    private String goodsName;

    /**
     * 商品类别
     */
    private GoodsTypeDTO goodsType;

    /**
     * 商品计量单位
     */
    private GoodsUnitDTO goodsUnit;

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
     * 备注
     */
    private String memo;

    /**
     * 创建人ID
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

    /**
     * 逻辑删除
     */
    private Boolean logicDelete;
}