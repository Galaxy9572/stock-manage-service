package com.jy.stock.pojo.request.goods;

import com.jy.stock.pojo.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加/修改商品计量单位请求
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddModifyGoodsUnitReq extends AddModifyRequest {

    @NotBlank(message = "{goods.unit.name.can.not.null}")
    private String unitName;

    /**
     * 是否允许小数
     */
    @NotNull(message = "{goods.unit.allow.decimal.can.not.null}")
    private Boolean allowDecimal;
}
