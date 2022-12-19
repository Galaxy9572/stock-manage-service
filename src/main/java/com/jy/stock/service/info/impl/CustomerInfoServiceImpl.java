package com.jy.stock.service.info.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.info.CustomerInfo;
import com.jy.stock.dao.mapper.info.CustomerInfoMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.CustomerInfoDTO;
import com.jy.stock.pojo.dto.system.UserInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyCustomerInfoReq;
import com.jy.stock.pojo.request.info.QueryCustomerInfoReq;
import com.jy.stock.service.info.CustomerInfoService;
import com.jy.stock.service.system.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 客户信息service
 *
 * @author liaojunyao
 */
@Service
public class CustomerInfoServiceImpl extends EnhancedServiceImpl<CustomerInfoMapper, CustomerInfo, CustomerInfoDTO> implements CustomerInfoService {

    @Resource
    private UserInfoService userInfoService;

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
            LambdaQueryWrapper<CustomerInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(CustomerInfo::getCustomerName, customerInfo.getCustomerName());
            customerInfo = getOne(queryWrapper);
            AssertUtils.isTrue(customerInfo == null || customerInfo.getId().equals(request.getId()), "customer.already.exists");
            CustomerInfo entity = new CustomerInfo();
            BeanCopyUtils.copy(request, entity);
            int updatedLines = baseMapper.updateById(entity);
            AssertUtils.isTrue(updatedLines > 0, "operate.failed");
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
        queryWrapper.eq(CustomerInfo::getCustomerName, customerName);
        CustomerInfo customerInfo = getOne(queryWrapper);
        AssertUtils.isNotNull(customerInfo, "customer.not.exist");
        return toDto(customerInfo);
    }

    @Override
    protected CustomerInfoDTO toDto(CustomerInfo customerInfo) {
        if (customerInfo == null) {
            return null;
        }
        CustomerInfoDTO dto = super.toDto(customerInfo);
        List<Long> userIdList = Arrays.asList(customerInfo.getCreateUserId(), customerInfo.getUpdateUserId());
        Map<Long, UserInfoDTO> userMap = userInfoService.batchListUserInfo(userIdList);
        dto.setCreateUser(userMap.get(customerInfo.getCreateUserId()));
        dto.setUpdateUser(userMap.get(customerInfo.getUpdateUserId()));
        return dto;
    }

    @Override
    public Class<CustomerInfoDTO> getDtoClass() {
        return CustomerInfoDTO.class;
    }
}
