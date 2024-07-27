package com.jy.stock.model.request.goods;

import com.jy.stock.enums.common.SortOrderEnum;
import com.jy.stock.model.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryGoodsUnitReq extends PageRequest {

    private String unitName;

    private SortOrderEnum sortOrder;

}
