package com.jy.stock.pojo.request.info;

import com.jy.stock.pojo.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryCustomerInfoReq extends PageRequest {

    private String keyword;

}
