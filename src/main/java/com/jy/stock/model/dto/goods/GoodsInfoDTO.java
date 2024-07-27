package com.jy.stock.model.dto.goods;

import com.jy.stock.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 商品
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsInfoDTO extends BaseDTO {

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

}