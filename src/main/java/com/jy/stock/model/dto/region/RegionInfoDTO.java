package com.jy.stock.model.dto.region;

import lombok.Data;

/**
 * 区域信息
 * @author liaojunyao
 */
@Data
public class RegionInfoDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 国家编码
     */
    private String countryCode;

    /**
     * 国家描述
     */
    private String countryDesc;

    /**
     * 省/自治区/州编码
     */
    private String stateCode;

    /**
     * 省/自治区/州描述
     */
    private String stateDesc;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市描述
     */
    private String cityDesc;

    /**
     * 区县编码
     */
    private String districtCode;

    /**
     * 区县描述
     */
    private String districtDesc;

    /**
     * 区域等级
     */
    private String level;
}