package com.jy.stock.enums.system.operation;

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
public enum ModuleEnum {

    /**
     * 商品
     */
    GOODS("GOODS", "商品管理"),

    /**
     * 订单
     */
    ORDER("ORDER", "订单管理"),

    /**
     * 系统
     */
    SYSTEM("SYSTEM", "系统管理"),

    /**
     * 客户
     */
    CUSTOMER("CUSTOMER", "客户管理"),

    /**
     * 供应商
     */
    SUPPLIER("SUPPLIER", "供应商管理");

    private final String code;

    private final String desc;

    public static ModuleEnum getByCode(String code) {
        return Arrays.stream(ModuleEnum.values()).filter(e -> e.code.equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAll(){
        return Arrays.stream(ModuleEnum.values()).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }

}
