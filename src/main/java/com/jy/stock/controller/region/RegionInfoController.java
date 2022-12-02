package com.jy.stock.controller.region;

import com.jy.stock.service.region.RegionInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 区域信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/region/info")
public class RegionInfoController {

    @Resource
    private RegionInfoService regionInfoService;


}
