package com.jy.stock.enums.system;

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
public enum SubModuleEnum {

    /**
     * 商品信息
     */
    GOODS_INFO(ModuleEnum.GOODS, "GOODS_INFO", "商品信息管理"),

    /**
     * 商品类型
     */
    GOODS_TYPE(ModuleEnum.GOODS,"GOODS_TYPE", "商品类型管理"),

    /**
     * 商品计量单位
     */
    GOODS_UNIT(ModuleEnum.GOODS,"GOODS_UNIT", "商品计量单位管理"),

    /**
     * 订单信息
     */
    ORDER(ModuleEnum.ORDER,"ORDER", "订单管理"),

    /**
     * 用户信息
     */
    USER(ModuleEnum.SYSTEM,"USER", "用户管理"),

    /**
     * 客户信息
     */
    CUSTOMER(ModuleEnum.INFO,"CUSTOMER", "客户信息管理"),

    /**
     * 供应商信息
     */
    SUPPLIER(ModuleEnum.INFO,"SUPPLIER", "供应商管理");

    private final ModuleEnum module;

    private final String code;

    private final String desc;

    public static SubModuleEnum getByCode(String code) {
        return Arrays.stream(SubModuleEnum.values()).filter(e -> e.code.equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAll(){
        return Arrays.stream(SubModuleEnum.values()).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }

    public static List<EnumCodeDescVO> listByModule(ModuleEnum module){
        return Arrays.stream(SubModuleEnum.values()).filter(e -> e.module == module).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }

}
