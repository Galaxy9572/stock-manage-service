package com.jy.stock.controller.region;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.model.dto.region.RegionInfoDTO;
import com.jy.stock.model.request.region.QueryRegionRequest;
import com.jy.stock.model.vo.region.RegionInfoVO;
import com.jy.stock.service.region.RegionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区域信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/region/info")
public class RegionInfoController extends EnhancedController<RegionInfoVO, RegionInfoDTO> {

    @Autowired
    private RegionInfoService regionInfoService;

    @PostMapping("/list")
    public HttpResult<List<RegionInfoVO>> listRegions(@RequestBody QueryRegionRequest request) {
        List<RegionInfoDTO> dtoList = regionInfoService.listRegions(request);
        List<RegionInfoVO> voList = StreamUtils.mapCollect(dtoList, this::toVo);
        return HttpResult.success(voList);
    }

    @Override
    public Class<RegionInfoVO> getVoClass() {
        return RegionInfoVO.class;
    }

}
