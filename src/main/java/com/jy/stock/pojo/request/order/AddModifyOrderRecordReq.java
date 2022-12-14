package com.jy.stock.pojo.request.order;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liaojunyao
 */
@Data
public class AddModifyOrderRecordReq {

    private Long id;

    private String orderType;

    private BigDecimal totalPrice;

    private String paymentMethod;

    private String memo;

    private Long supplierId;

    private Long customerId;

    private List<AddModifyOrderRecordDetailReq> orderRecordDetailList;

}
