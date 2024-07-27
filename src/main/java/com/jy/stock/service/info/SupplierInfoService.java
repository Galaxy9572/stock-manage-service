package com.jy.stock.service.info;

import com.jy.stock.model.entity.info.SupplierInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.SupplierInfoDTO;
import com.jy.stock.model.request.info.AddModifySupplierInfoReq;
import com.jy.stock.model.request.info.QuerySupplierInfoReq;

/**
 * @author liaojunyao
 */
public interface SupplierInfoService extends IService<SupplierInfo>{


    SupplierInfoDTO addModifySupplierInfo(AddModifySupplierInfoReq request);

    boolean deleteSupplierInfo(Long id);

    PageDTO<SupplierInfoDTO> listSupplierInfoByPage(QuerySupplierInfoReq request);

    SupplierInfoDTO getSupplierInfoById(Long id);

    SupplierInfoDTO getSupplierInfoByName(String supplierName);
}
