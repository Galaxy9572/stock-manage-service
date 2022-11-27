package com.jy.stock.pojo.request.goods;

import com.jy.stock.pojo.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryGoodsInfoReq extends PageRequest {

    private String goodsName;

    private Long goodsUnitId;

    private Long goodsTypeId;

}
