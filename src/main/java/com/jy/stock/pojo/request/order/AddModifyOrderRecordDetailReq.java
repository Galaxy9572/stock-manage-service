package com.jy.stock.pojo.request.order;

import com.jy.stock.pojo.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddModifyOrderRecordDetailReq extends AddModifyRequest {

    private Long goodsId;

    private BigDecimal unitPrice;

    private BigDecimal discount;

    private BigDecimal amount;

    private BigDecimal totalPrice;

    private Long supplierId;

    private Long customerId;

}
