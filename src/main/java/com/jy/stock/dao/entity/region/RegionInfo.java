package com.jy.stock.dao.entity.region;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 区域信息
 * @author liaojunyao
 */
@Data
@TableName(value = "region_info")
public class RegionInfo {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
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