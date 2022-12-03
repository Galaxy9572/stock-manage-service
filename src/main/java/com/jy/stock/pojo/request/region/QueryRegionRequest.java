package com.jy.stock.pojo.request.region;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author liaojunyao
 */
@Data
public class QueryRegionRequest {

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

    /**
     * 区域等级
     */
    @NotBlank(message = "{region.level.can.not.null}")
    private String level;

}
