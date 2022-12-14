package com.jy.stock.pojo.request.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liaojunyao
 */
@Data
public class AddModifyOrderRecordDetailReq {

    private Long id;

    private Long goodsId;

    private BigDecimal unitPrice;

    private BigDecimal discount;

    private BigDecimal amount;

    private BigDecimal totalPrice;

    private Long supplierId;

    private Long customerId;

}
