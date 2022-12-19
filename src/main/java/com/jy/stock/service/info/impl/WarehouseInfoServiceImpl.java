package com.jy.stock.service.info.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.info.WarehouseInfo;
import com.jy.stock.dao.mapper.info.WarehouseInfoMapper;
import com.jy.stock.pojo.dto.info.WarehouseInfoDTO;
import com.jy.stock.service.info.WarehouseInfoService;
import org.springframework.stereotype.Service;
/**
 * @author liaojunyao
 */
@Service
public class WarehouseInfoServiceImpl extends EnhancedServiceImpl<WarehouseInfoMapper, WarehouseInfo, WarehouseInfoDTO> implements WarehouseInfoService{

    @Override
    public Class<WarehouseInfoDTO> getDtoClass() {
        return WarehouseInfoDTO.class;
    }
}
