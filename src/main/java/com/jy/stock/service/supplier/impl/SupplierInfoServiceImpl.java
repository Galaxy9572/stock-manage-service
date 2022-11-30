package com.jy.stock.service.supplier.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.supplier.SupplierInfo;
import com.jy.stock.dao.mapper.supplier.SupplierInfoMapper;
import com.jy.stock.pojo.dto.supplier.SupplierInfoDTO;
import com.jy.stock.service.supplier.SupplierInfoService;
import org.springframework.stereotype.Service;

/**
 * @author liaojunyao
 */
@Service
public class SupplierInfoServiceImpl extends EnhancedServiceImpl<SupplierInfoMapper, SupplierInfo, SupplierInfoDTO> implements SupplierInfoService {

    @Override
    public Class<SupplierInfoDTO> getDtoClass() {
        return SupplierInfoDTO.class;
    }

}
