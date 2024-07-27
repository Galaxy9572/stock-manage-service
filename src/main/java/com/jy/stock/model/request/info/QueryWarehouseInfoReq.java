package com.jy.stock.model.request.info;

import com.jy.stock.model.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryWarehouseInfoReq extends PageRequest {

    private String keyword;

}
