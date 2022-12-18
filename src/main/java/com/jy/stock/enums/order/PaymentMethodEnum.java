package com.jy.stock.enums.order;

import com.jy.stock.common.response.EnumCodeDescVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author liaojunyao
 */
@Getter
@AllArgsConstructor
public enum PaymentMethodEnum {

    /**
     * 现金
     */
    CASH("CASH", "现金"),

    /**
     * 信用卡
     */
    CREDIT_CARD("CREDIT_CARD", "信用卡"),

    /**
     * 银联
     */
    UNION_PAY("UNION_PAY", "银联"),

    /**
     * 支付宝
     */
    ALIPAY("ALIPAY", "支付宝"),

    /**
     * 微信支付
     */
    WECHAT_PAY("WECHAT_PAY", "微信支付");

    private final String code;

    private final String desc;

    public static PaymentMethodEnum getByCode(String code) {
        return Arrays.stream(PaymentMethodEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAll(){
        return Arrays.stream(PaymentMethodEnum.values()).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }

}
