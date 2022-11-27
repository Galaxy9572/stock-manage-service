package com.jy.stock.pojo.request.goods;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liaojunyao
 */
@Data
public class AddModifyGoodsInfoReq {

    private Long id;

    /**
     * 品名
     */
    @NotBlank(message = "{goods.name.can.not.empty}")
    private String goodsName;

    /**
     * 商品类别ID
     */
    @NotNull(message = "{goods.type.id.can.not.null}")
    @Min(value = 1, message = "{goods.type.id.invalid}")
    private Long goodsTypeId;

    /**
     * 商品计量单位ID
     */
    @NotNull(message = "{goods.unit.id.can.not.null}")
    @Min(value = 1, message = "{goods.unit.id.invalid}")
    private Long goodsUnitId;

    /**
     * 备注
     */
    private String memo;

}
