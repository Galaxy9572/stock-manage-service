package com.jy.stock.common.enums;

import com.jy.stock.pojo.response.user.UserRoleEnumVO;
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

    public static List<UserRoleEnumVO> listAllRoles(){
        return Arrays.stream(UserRoleEnum.values()).map(e -> new UserRoleEnumVO(e.getCode(), e.getDesc())).collect(Collectors.toList());
    }

}