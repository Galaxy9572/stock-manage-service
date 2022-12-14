package com.jy.stock.pojo.dto.goods;

import com.jy.stock.pojo.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品库存
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsStockDTO extends BaseDTO {

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

}