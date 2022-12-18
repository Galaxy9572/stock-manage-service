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
public enum OperationTypeEnum {

    /**
     * 新增/修改
     */
    ADD_MODIFY("ADD_MODIFY", "新增/修改", false),

    /**
     * 新增
     */
    ADD("ADD", "新增", true),

    /**
     * 删除
     */
    DELETE("DELETE", "删除", true),

    /**
     * 修改
     */
    UPDATE("UPDATE", "修改", true);

    private final String code;

    private final String desc;

    private final boolean showInUI;

    public static OperationTypeEnum getByCode(String code) {
        return Arrays.stream(OperationTypeEnum.values()).filter(e -> e.code.equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAll(){
        return Arrays.stream(OperationTypeEnum.values()).filter(OperationTypeEnum::isShowInUI).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).toList();
    }

    public static boolean isAddOrModify(String code) {
        return ADD.code.equals(code) || UPDATE.code.equals(code) || ADD_MODIFY.code.equals(code);
    }

}
