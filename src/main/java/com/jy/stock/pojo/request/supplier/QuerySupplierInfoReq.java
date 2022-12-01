package com.jy.stock.pojo.request.supplier;

import com.jy.stock.pojo.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuerySupplierInfoReq extends PageRequest {

    private String keyword;

}
