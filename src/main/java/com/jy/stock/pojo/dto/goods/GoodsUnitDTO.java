package com.jy.stock.pojo.dto.goods;

import com.jy.stock.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsUnitDTO extends BaseDTO {

    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 是否允许小数
     */
    private Boolean allowDecimal;

}