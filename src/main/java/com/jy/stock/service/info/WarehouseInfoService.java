package com.jy.stock.service.info;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.info.WarehouseInfo;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.WarehouseInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyWarehouseInfoReq;
import com.jy.stock.pojo.request.info.QueryWarehouseInfoReq;
import org.springframework.transaction.annotation.Transactional;

public interface WarehouseInfoService extends IService<WarehouseInfo>{

    @Transactional(rollbackFor = Exception.class)
    WarehouseInfoDTO addModifyWarehouseInfo(AddModifyWarehouseInfoReq request);

    boolean deleteWarehouseInfo(Long id);

    WarehouseInfoDTO getWarehouseInfoDetail(Long id);

    PageDTO<WarehouseInfoDTO> listWarehouseInfoByPage(QueryWarehouseInfoReq request);

    WarehouseInfoDTO checkExistenceByName(String warehouseName, boolean assertExists);
}
