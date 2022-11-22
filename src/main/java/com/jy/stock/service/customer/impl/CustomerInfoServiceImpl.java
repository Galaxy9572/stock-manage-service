package com.jy.stock.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.jy.stock.dao.mapper.customer.CustomerInfoMapper;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.request.customer.AddModifyCustomerInfoReq;
import com.jy.stock.service.customer.CustomerInfoService;
import org.springframework.stereotype.Service;

/**
 * 客户信息service
 *
 * @author liaojunyao
 */
@Service
public class CustomerInfoServiceImpl extends EnhancedServiceImpl<CustomerInfoMapper, CustomerInfo, CustomerInfoDTO> implements CustomerInfoService {

    public CustomerInfoDTO addModifyCustomerInfo(AddModifyCustomerInfoReq request) {
        Long id = request.getId();
        if (id == null) {
            // id为空，新增
            LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CustomerInfo::getCustomerName, request.getCustomerName())
                    .eq(CustomerInfo::getLogicDelete, false);
            long count = count(queryWrapper);
        } else {

        }

        return null;
    }

    @Override
    public CustomerInfoDTO getCustomerInfoByName(String customerName) {
        LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerInfo::getCustomerName, customerName)
                .eq(CustomerInfo::getLogicDelete, false);
        CustomerInfo customerInfo = getOne(queryWrapper);
        AssertUtils.isNotNull(customerInfo, "customer.not.exist");
        return toDto(customerInfo);
    }

    @Override
    public Class<CustomerInfoDTO> getDtoClass() {
        return CustomerInfoDTO.class;
    }
}
