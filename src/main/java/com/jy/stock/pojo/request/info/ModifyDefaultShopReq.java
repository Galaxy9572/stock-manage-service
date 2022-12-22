package com.jy.stock.pojo.request.info;

import com.jy.stock.pojo.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * 门店信息
 *
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyDefaultShopReq extends AddModifyRequest {

    @NotNull(message = "{default.shop.can.not.empty}")
    private Boolean defaultShop;

}