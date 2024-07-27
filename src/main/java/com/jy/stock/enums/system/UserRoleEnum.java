package com.jy.stock.enums.system;

import com.jy.stock.common.response.CodeDescVO;
import com.jy.stock.common.util.StreamUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 用户角色枚举
 * @author liaojunyao
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    /** 管理员 */
    ADMIN("ADMIN", "管理员"),

    /** 普通用户，只能查看 */
    USER("USER", "普通用户");

    private final String code;

    private final String desc;

    public static UserRoleEnum getByCode(String code) {
        return StreamUtils.findFirst(UserRoleEnum.values(), e -> e.getCode().equals(code));
    }

    public static List<CodeDescVO> listAllRoles(){
        return StreamUtils.mapCollect(UserRoleEnum.values(), e -> new CodeDescVO(e.getCode(), e.getDesc()));
    }

}
