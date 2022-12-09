package com.jy.stock.pojo.request.goods;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author liaojunyao
 */
@Data
public class ModifyGoodsStockWarningReq {

    @NotNull(message = "{id.can.not.null}")
    private Long id;

    /**
     * 最低库存数量
     */
    @Min(value = 1, message = "{goods.stock.min.stock.num.invalid}")
    private Long minStockNum;

    /**
     * 最高库存数量
     */
    @Min(value = 1, message = "{goods.stock.max.stock.num.invalid}")
    private Long maxStockNum;

    /**
     * 是否允许库存告警
     */
    @NotNull(message = "{goods.stock.allow.stock.warning.invalid}")
    private Boolean allowStockWarning;

}
