package com.jy.stock.pojo.response.region;

import lombok.Data;

/**
 * 区域信息
 * @author liaojunyao
 */
@Data
public class RegionInfoVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 国家编码
     */
    private String countryCode;

    /**
     * 省/自治区/州编码
     */
    private String stateCode;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 区县编码
     */
    private String districtCode;
}