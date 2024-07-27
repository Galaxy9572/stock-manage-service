package com.jy.stock.model.request.order;

import com.jy.stock.model.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryOrderRecordReq extends PageRequest {

    private String keyword;

    private String orderType;

    private String goodsType;

    private LocalDateTime orderStartTime;

    private LocalDateTime orderEndTime;

}
