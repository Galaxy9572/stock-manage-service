package com.jy.stock.service.info.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.mapper.info.WarehouseInfoMapper;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.WarehouseInfoDTO;
import com.jy.stock.model.dto.system.UserInfoDTO;
import com.jy.stock.model.entity.info.WarehouseInfo;
import com.jy.stock.model.request.info.AddModifyWarehouseInfoReq;
import com.jy.stock.model.request.info.QueryWarehouseInfoReq;
import com.jy.stock.service.info.WarehouseInfoService;
import com.jy.stock.service.system.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author liaojunyao
 */
@Service
public class WarehouseInfoServiceImpl extends EnhancedServiceImpl<WarehouseInfoMapper, WarehouseInfo, WarehouseInfoDTO> implements WarehouseInfoService{

    @Autowired
    private UserInfoService userInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WarehouseInfoDTO addModifyWarehouseInfo(AddModifyWarehouseInfoReq request) {
        var id = request.getId();
        var isSuccess = false;
        if (id == null) {
            var warehouseName = request.getWarehouseName();
            checkExistenceByName(warehouseName, false);
            var entity = new WarehouseInfo();
            BeanCopyUtils.copy(request, entity);
            isSuccess = save(entity);
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return toDto(getById(entity.getId()));
        } else {
            var warehouseInfoDTO = checkExistenceById(id, true);
            if(StringUtils.equals(warehouseInfoDTO.getWarehouseName(), request.getWarehouseName())) {
                return warehouseInfoDTO;
            }
            var queryWrapper = getQueryWrapper();
            queryWrapper.eq(WarehouseInfo::getWarehouseName, request.getWarehouseName());
            var warehouseInfo = getOne(queryWrapper);
            AssertUtils.isTrue(warehouseInfo == null || warehouseInfo.getId().equals(id), "data.already.exist");
            warehouseInfo = new WarehouseInfo();
            BeanCopyUtils.copy(request, warehouseInfo);
            isSuccess = updateById(warehouseInfo);
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return toDto(getById(id));
        }
    }

    @Override
    public boolean deleteWarehouseInfo(Long id) {
        checkExistenceById(id, true);
        return removeById(id);
    }

    @Override
    public WarehouseInfoDTO getWarehouseInfoDetail(Long id) {
        return checkExistenceById(id, true);
    }

    @Override
    public PageDTO<WarehouseInfoDTO> listWarehouseInfoByPage(QueryWarehouseInfoReq request) {
        var pageParam = new Page<WarehouseInfo>(request.getPageNo(), request.getPageSize());
        IPage<WarehouseInfo> page = baseMapper.listWarehouseInfoByPage(pageParam, request);
        return toPageDTO(page);
    }

    @Override
    public WarehouseInfoDTO checkExistenceByName(String warehouseName, boolean assertExists) {
        LambdaQueryWrapper<WarehouseInfo> queryWrapper = getQueryWrapper();
        queryWrapper.eq(WarehouseInfo::getWarehouseName, warehouseName);
        var warehouseInfo = getOne(queryWrapper);
        if (assertExists) {
            AssertUtils.isNotNull(warehouseInfo, "data.not.exist");
        } else {
            AssertUtils.isNull(warehouseInfo, "data.already.exist");
        }
        return warehouseInfo != null ? toDto(warehouseInfo) : null;
    }

    @Override
    protected WarehouseInfoDTO toDto(WarehouseInfo warehouseInfo) {
        WarehouseInfoDTO warehouseInfoDTO = super.toDto(warehouseInfo);
        Long createUserId = warehouseInfo.getCreateUserId();
        Long updateUserId = warehouseInfo.getUpdateUserId();
        Set<Long> userIdSet = new HashSet<>();
        userIdSet.add(createUserId);
        userIdSet.add(updateUserId);
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        warehouseInfoDTO.setCreateUser(userInfoMap.get(createUserId));
        warehouseInfoDTO.setUpdateUser(userInfoMap.get(updateUserId));
        return warehouseInfoDTO;
    }

    @Override
    protected List<WarehouseInfoDTO> toDtoList(List<WarehouseInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        Set<Long> userIdSet = new HashSet<>();
        list.forEach(u -> {
            userIdSet.add(u.getCreateUserId());
            userIdSet.add(u.getUpdateUserId());
        });
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        return StreamUtils.mapCollect(list, e -> {
            WarehouseInfoDTO warehouseInfoDTO = super.toDto(e);
            warehouseInfoDTO.setCreateUser(userInfoMap.get(e.getCreateUserId()));
            warehouseInfoDTO.setUpdateUser(userInfoMap.get(e.getUpdateUserId()));
            return warehouseInfoDTO;
        });
    }

    @Override
    public Class<WarehouseInfoDTO> getDtoClass() {
        return WarehouseInfoDTO.class;
    }
}
