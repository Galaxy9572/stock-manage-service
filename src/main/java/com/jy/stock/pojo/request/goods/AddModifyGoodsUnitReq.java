package com.jy.stock.pojo.request.goods;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 添加/修改商品计量单位请求
 * @author liaojunyao
 */
@Data
public class AddModifyGoodsUnitReq {

    private Long id;

    @NotBlank
    private String unitName;

    /**
     * 是否允许小数
     */
    @NotNull
    private Boolean allowDecimal;
}
