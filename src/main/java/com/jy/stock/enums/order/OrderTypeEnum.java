package com.jy.stock.enums.order;

import com.jy.stock.pojo.response.order.OrderTypeVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<OrderTypeVO> listAll(){
        return Arrays.stream(OrderTypeEnum.values()).map(e -> new OrderTypeVO(e.getCode(), e.getDesc())).collect(Collectors.toList());
    }
}
