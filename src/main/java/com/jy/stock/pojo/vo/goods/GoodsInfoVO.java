package com.jy.stock.pojo.vo.goods;

import com.jy.stock.pojo.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 商品
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsInfoVO extends BaseVO {

    /**
     * 品名
     */
    private String goodsName;

    /**
     * 商品类别
     */
    private GoodsTypeVO goodsType;

    /**
     * 商品计量单位
     */
    private GoodsUnitVO goodsUnit;

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

}