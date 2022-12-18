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
public enum OrderTypeEnum {

    /**
     * 库存初始化
     */
    INIT_STOCK("INIT_STOCK", "库存初始化"),

    /**
     * 进货
     */
    REPLENISH("REPLENISH", "进货"),

    /**
     * 发货
     */
    DISPATCH("DISPATCH", "发货");

    private final String code;

    private final String desc;

    public static OrderTypeEnum getByCode(String code) {
        return Arrays.stream(OrderTypeEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAll(){
        return Arrays.stream(OrderTypeEnum.values()).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }
}
