package com.jy.stock.enums.order;

import com.jy.stock.common.response.CodeDescVO;
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
    INIT_STOCK("INIT_STOCK", "库存初始化", false),

    /**
     * 进货
     */
    REPLENISH("REPLENISH", "进货", true),

    /**
     * 发货
     */
    DISPATCH("DISPATCH", "发货", true);

    private final String code;

    private final String desc;

    private final boolean showInUI;

    public static OrderTypeEnum getByCode(String code) {
        return Arrays.stream(OrderTypeEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public static List<CodeDescVO> listAll(){
        return Arrays.stream(OrderTypeEnum.values()).filter(OrderTypeEnum::isShowInUI).map(e -> new CodeDescVO(e.getCode(), e.getDesc())).toList();
    }
}
