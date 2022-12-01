package com.jy.stock.service.supplier;

import com.jy.stock.dao.entity.supplier.SupplierInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.supplier.SupplierInfoDTO;
import com.jy.stock.pojo.request.supplier.AddModifySupplierInfoReq;
import com.jy.stock.pojo.request.supplier.QuerySupplierInfoReq;

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
