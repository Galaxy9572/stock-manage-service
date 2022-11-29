package com.jy.stock.pojo.request.goods;

import com.jy.stock.common.validate.annotation.goods.ValidateWholesalePrice;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;

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
     * 进货价
     */
    @NotNull(message = "{goods.purchase.price.can.not.null}")
    @DecimalMin(value = "0.00", message = "{goods.price.must.greater.than.zero}")
    private BigDecimal purchasePrice;

    /**
     * 零售价
     */
    @NotNull(message = "{goods.retail.price.can.not.null}")
    @DecimalMin(value = "0.00", message = "{goods.price.must.greater.than.zero}")
    private BigDecimal retailPrice;

    /**
     * 批发价
     */
    @ValidateWholesalePrice
    private BigDecimal wholesalePrice;

    /**
     * 备注
     */
    private String memo;

}
