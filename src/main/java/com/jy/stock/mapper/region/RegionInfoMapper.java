package com.jy.stock.mapper.region;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.model.entity.region.RegionInfo;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface RegionInfoMapper extends BaseMapper<RegionInfo> {

    List<RegionInfo> listRegions(RegionInfo param);

}