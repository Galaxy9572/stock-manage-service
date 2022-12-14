package com.jy.stock.pojo.response.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liaojunyao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodVO {

    private String code;

    private String desc;

}
