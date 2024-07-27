package com.jy.stock.model.dto.goods;

import com.jy.stock.model.dto.BaseDTO;
import com.jy.stock.model.dto.info.WarehouseInfoDTO;
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
     * 仓库
     */
    private WarehouseInfoDTO warehouseInfo;

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