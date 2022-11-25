package com.jy.stock.service.customer.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.jy.stock.dao.mapper.customer.CustomerInfoMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.request.customer.AddModifyCustomerInfoReq;
import com.jy.stock.pojo.request.customer.QueryCustomerInfoReq;
import com.jy.stock.service.customer.CustomerInfoService;
import org.springframework.stereotype.Service;

/**
 * 客户信息service
 *
 * @author liaojunyao
 */
@Service
public class CustomerInfoServiceImpl extends EnhancedServiceImpl<CustomerInfoMapper, CustomerInfo, CustomerInfoDTO> implements CustomerInfoService {

    @Override
    public CustomerInfoDTO addModifyCustomerInfo(AddModifyCustomerInfoReq request) {
        Long id = request.getId();
        if (id == null) {
            // id为空，新增
            LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CustomerInfo::getCustomerName, request.getCustomerName());
            long count = count(queryWrapper);
            AssertUtils.isTrue(count == 0, "customer.already.exists");

            CustomerInfo entity = new CustomerInfo();
            BeanCopyUtils.copy(request, entity);
            boolean isSuccess = save(entity);
            AssertUtils.isTrue(isSuccess, "operate.failed");
        } else {
            CustomerInfo customerInfo = getById(id);
            AssertUtils.isNotNull(customerInfo, "customer.not.exist");
            if (!request.getCustomerName().equals(customerInfo.getCustomerName())) {
                CustomerInfo entity = new CustomerInfo();
                BeanCopyUtils.copy(request, entity);
                int updatedLines = baseMapper.updateById(entity);
                AssertUtils.isTrue(updatedLines > 0, "operate.failed");
            }
        }

        return getCustomerInfoByName(request.getCustomerName());
    }

    @Override
    public boolean deleteCustomerInfo(Long id){
        LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CustomerInfo::getId, id);
        long count = count(queryWrapper);
        AssertUtils.isTrue(count > 0, "customer.not.exist");
        return removeById(id);
    }

    @Override
    public PageDTO<CustomerInfoDTO> listCustomerInfoByPage(QueryCustomerInfoReq request) {
        Page<CustomerInfo> pageParam = new Page<>(request.getPageNo(), request.getPageSize());
        Page<CustomerInfo> page = baseMapper.listCustomerInfoByPage(pageParam, request);
        return toPageDTO(page);
    }

    @Override
    public CustomerInfoDTO getCustomerInfoById(Long id) {
        CustomerInfo customerInfo = getById(id);
        AssertUtils.isNotNull(customerInfo, "customer.not.exist");
        return toDto(customerInfo);
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
