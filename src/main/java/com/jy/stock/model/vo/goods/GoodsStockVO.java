package com.jy.stock.model.vo.goods;

import com.jy.stock.model.vo.BaseVO;
import com.jy.stock.model.vo.info.WarehouseInfoVO;
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
     * 仓库
     */
    private WarehouseInfoVO warehouseInfo;

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