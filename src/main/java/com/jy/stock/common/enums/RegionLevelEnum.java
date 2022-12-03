package com.jy.stock.common.enums;

import java.util.Arrays;

/**
 * @author liaojunyao
 */
public enum RegionLevelEnum {

    COUNTRY,

    STATE,

    CITY,

    DISTRICT;

    public static RegionLevelEnum getByCode(String code) {
        return Arrays.stream(RegionLevelEnum.values()).filter(e -> e.name().equals(code)).findFirst().orElse(null);
    }

}
