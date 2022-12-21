package com.jy.stock.pojo.vo.goods;

import com.jy.stock.pojo.vo.BaseVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品库存
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsStockVO extends BaseVO {

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
     * 是否允许库存告警
     */
    private Boolean allowStockWarning;

    /**
     * 当前库存数量
     */
    private Long currentStockNum;

}