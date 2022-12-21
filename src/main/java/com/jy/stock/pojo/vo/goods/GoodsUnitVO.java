package com.jy.stock.pojo.vo.goods;

import com.jy.stock.pojo.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsUnitVO extends BaseVO {

    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 是否允许小数
     */
    private Boolean allowDecimal;
}