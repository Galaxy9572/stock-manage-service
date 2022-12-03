package com.jy.stock.dao.mapper.region;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.region.RegionInfo;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface RegionInfoMapper extends BaseMapper<RegionInfo> {

    List<RegionInfo> listRegions(RegionInfo param);

}