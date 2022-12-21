package com.jy.stock.controller.info;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.pojo.dto.info.WarehouseInfoDTO;
import com.jy.stock.pojo.vo.info.WarehouseInfoVO;
import com.jy.stock.service.info.WarehouseInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 仓库信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/warehouse")
public class WarehouseInfoController extends EnhancedController<WarehouseInfoVO, WarehouseInfoDTO> {

    @Resource
    private WarehouseInfoService warehouseInfoService;

    @Override
    public Class<WarehouseInfoVO> getVoClass() {
        return WarehouseInfoVO.class;
    }
}
