package com.jy.stock.service.supplier.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.supplier.SupplierInfo;
import com.jy.stock.dao.mapper.supplier.SupplierInfoMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.supplier.SupplierInfoDTO;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.pojo.request.supplier.AddModifySupplierInfoReq;
import com.jy.stock.pojo.request.supplier.QuerySupplierInfoReq;
import com.jy.stock.service.supplier.SupplierInfoService;
import com.jy.stock.service.user.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author liaojunyao
 */
@Service
public class SupplierInfoServiceImpl extends EnhancedServiceImpl<SupplierInfoMapper, SupplierInfo, SupplierInfoDTO> implements SupplierInfoService {

    @Resource
    private UserInfoService userInfoService;

    @Override
    public SupplierInfoDTO addModifySupplierInfo(AddModifySupplierInfoReq request) {
        Long id = request.getId();
        if (id == null) {
            // id为空，新增
            LambdaQueryWrapper<SupplierInfo> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(SupplierInfo::getSupplierName, request.getSupplierName());
            long count = count(queryWrapper);
            AssertUtils.isTrue(count == 0, "supplier.already.exists");

            SupplierInfo entity = new SupplierInfo();
            BeanCopyUtils.copy(request, entity);
            boolean isSuccess = save(entity);
            AssertUtils.isTrue(isSuccess, "operate.failed");
        } else {
            SupplierInfo supplierInfo = getById(id);
            AssertUtils.isNotNull(supplierInfo, "supplier.not.exist");
            if (!request.getSupplierName().equals(supplierInfo.getSupplierName())) {
                SupplierInfo entity = new SupplierInfo();
                BeanCopyUtils.copy(request, entity);
                int updatedLines = baseMapper.updateById(entity);
                AssertUtils.isTrue(updatedLines > 0, "operate.failed");
            }
        }

        return getSupplierInfoByName(request.getSupplierName());
    }

    @Override
    public boolean deleteSupplierInfo(Long id){
        LambdaQueryWrapper<SupplierInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SupplierInfo::getId, id);
        long count = count(queryWrapper);
        AssertUtils.isTrue(count > 0, "supplier.not.exist");
        return removeById(id);
    }

    @Override
    public PageDTO<SupplierInfoDTO> listSupplierInfoByPage(QuerySupplierInfoReq request) {
        Page<SupplierInfo> pageParam = new Page<>(request.getPageNo(), request.getPageSize());
        Page<SupplierInfo> page = baseMapper.listSupplierInfoByPage(pageParam, request);
        return toPageDTO(page);
    }

    @Override
    public SupplierInfoDTO getSupplierInfoById(Long id) {
        SupplierInfo supplierInfo = getById(id);
        AssertUtils.isNotNull(supplierInfo, "supplier.not.exist");
        return toDto(supplierInfo);
    }

    @Override
    public SupplierInfoDTO getSupplierInfoByName(String supplierName) {
        LambdaQueryWrapper<SupplierInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SupplierInfo::getSupplierName, supplierName)
                .eq(SupplierInfo::getLogicDelete, false);
        SupplierInfo supplierInfo = getOne(queryWrapper);
        AssertUtils.isNotNull(supplierInfo, "supplier.not.exist");
        return toDto(supplierInfo);
    }

    @Override
    protected SupplierInfoDTO toDto(SupplierInfo supplierInfo) {
        if (supplierInfo == null) {
            return null;
        }
        SupplierInfoDTO dto = super.toDto(supplierInfo);
        List<Long> userIdList = Arrays.asList(supplierInfo.getCreateUserId(), supplierInfo.getUpdateUserId());
        Map<Long, UserInfoDTO> userMap = userInfoService.batchListUserInfo(userIdList);
        dto.setCreateUser(userMap.get(supplierInfo.getCreateUserId()));
        dto.setUpdateUser(userMap.get(supplierInfo.getUpdateUserId()));
        return dto;
    }

    @Override
    public Class<SupplierInfoDTO> getDtoClass() {
        return SupplierInfoDTO.class;
    }

}
