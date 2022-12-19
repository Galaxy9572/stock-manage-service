package com.jy.stock.enums.system;

import com.jy.stock.common.response.EnumCodeDescVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色枚举
 * @author liaojunyao
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    /** 管理员 */
    ADMIN("admin", "管理员"),

    /** 普通用户，只能查看 */
    USER("user", "普通用户");

    private final String code;

    private final String desc;

    public static UserRoleEnum getByCode(String code) {
        return Arrays.stream(UserRoleEnum.values()).filter(e -> e.getCode().equals(code)).findFirst().orElse(null);
    }

    public static List<EnumCodeDescVO> listAllRoles(){
        return Arrays.stream(UserRoleEnum.values()).map(e -> new EnumCodeDescVO(e.getCode(), e.getDesc())).collect(Collectors.toList());
    }

}
