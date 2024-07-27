package com.jy.stock.service.region;

import com.jy.stock.model.entity.region.RegionInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.dto.region.RegionInfoDTO;
import com.jy.stock.model.request.region.QueryRegionRequest;

import java.util.List;

public interface RegionInfoService extends IService<RegionInfo>{


    List<RegionInfoDTO> listRegions(QueryRegionRequest request);
}
