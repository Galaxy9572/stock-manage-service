package com.jy.stock.pojo.request.order;

import com.jy.stock.pojo.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddModifyOrderRecordReq extends AddModifyRequest {

    private String orderType;

    private BigDecimal totalPrice;

    private String paymentMethod;

    private String memo;

    private Long supplierId;

    private Long customerId;

    private List<AddModifyOrderRecordDetailReq> orderRecordDetailList;

}
