package com.jy.stock.service.info.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.DistributedLocker;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.constants.info.InfoLockKey;
import com.jy.stock.mapper.info.ShopInfoMapper;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.ShopInfoDTO;
import com.jy.stock.model.dto.system.UserInfoDTO;
import com.jy.stock.model.entity.info.ShopInfo;
import com.jy.stock.model.request.info.AddModifyShopInfoReq;
import com.jy.stock.model.request.info.QueryShopInfoReq;
import com.jy.stock.service.info.ShopInfoService;
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
public class ShopInfoServiceImpl extends EnhancedServiceImpl<ShopInfoMapper, ShopInfo, ShopInfoDTO> implements ShopInfoService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private DistributedLocker locker;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ShopInfoDTO addModifyShopInfo(AddModifyShopInfoReq request) {
        var id = request.getId();
        var isSuccess = false;
        Boolean isDefaultShop = request.getDefaultShop();
        if (id == null) {
            var shopName = request.getShopName();
            checkExistenceByName(shopName, false);
            var entity = new ShopInfo();
            BeanCopyUtils.copy(request, entity);
            isSuccess = save(entity);
            if (isDefaultShop) {
                boolean isLocked = locker.tryLock(InfoLockKey.DEFAULT_SHOP_KEY, 3, -1);
                try {
                    if (isLocked) {
                        baseMapper.disableDefaultShopException(entity.getId());
                    }
                } finally {
                    if (isLocked) {
                        locker.unlock(InfoLockKey.DEFAULT_SHOP_KEY);
                    }
                }
            }
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return toDto(getById(entity.getId()));
        } else {
            var shopInfoDTO = checkExistenceById(id, true);
            if (StringUtils.equals(shopInfoDTO.getShopName(), request.getShopName())) {
                return shopInfoDTO;
            }
            var queryWrapper = getQueryWrapper();
            queryWrapper.eq(ShopInfo::getShopName, request.getShopName());
            var shopInfo = getOne(queryWrapper);
            AssertUtils.isTrue(shopInfo == null || shopInfo.getId().equals(id), "data.already.exist");
            shopInfo = new ShopInfo();
            BeanCopyUtils.copy(request, shopInfo);
            isSuccess = updateById(shopInfo);
            if (isDefaultShop) {
                boolean isLocked = locker.tryLock(InfoLockKey.DEFAULT_SHOP_KEY, 3, -1);
                try {
                    if (isLocked) {
                        baseMapper.disableDefaultShopException(id);
                    }
                } finally {
                    if (isLocked) {
                        locker.unlock(InfoLockKey.DEFAULT_SHOP_KEY);
                    }
                }
            }
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return toDto(getById(id));
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean setDefaultShop(Long id, boolean isDefault) {
        checkExistenceById(id, true);
        boolean isSuccess;
        boolean isLocked = locker.tryLock(InfoLockKey.DEFAULT_SHOP_KEY, 3, -1);
        AssertUtils.isTrue(isLocked, "system.is.busy");
        try {
            ShopInfo updateEntity = new ShopInfo();
            updateEntity.setId(id);
            updateEntity.setDefaultShop(isDefault);
            isSuccess = updateById(updateEntity);
            if (isDefault) {
                baseMapper.disableDefaultShopException(id);
            }
        } finally {
            locker.unlock(InfoLockKey.DEFAULT_SHOP_KEY);
        }
        return isSuccess;
    }

    @Override
    public boolean deleteShopInfo(Long id) {
        checkExistenceById(id, true);
        return removeById(id);
    }

    @Override
    public ShopInfoDTO getShopInfoDetail(Long id) {
        return checkExistenceById(id, true);
    }

    @Override
    public PageDTO<ShopInfoDTO> listShopInfoByPage(QueryShopInfoReq request) {
        var pageParam = new Page<ShopInfo>(request.getPageNo(), request.getPageSize());
        IPage<ShopInfo> page = baseMapper.listShopInfoByPage(pageParam, request);
        return toPageDTO(page);
    }

    @Override
    public ShopInfoDTO checkExistenceByName(String shopName, boolean assertExists) {
        LambdaQueryWrapper<ShopInfo> queryWrapper = getQueryWrapper();
        queryWrapper.eq(ShopInfo::getShopName, shopName);
        var shopInfo = getOne(queryWrapper);
        if (assertExists) {
            AssertUtils.isNotNull(shopInfo, "data.not.exist");
        } else {
            AssertUtils.isNull(shopInfo, "data.already.exist");
        }
        return shopInfo != null ? toDto(shopInfo) : null;
    }

    @Override
    protected ShopInfoDTO toDto(ShopInfo shopInfo) {
        ShopInfoDTO shopInfoDTO = super.toDto(shopInfo);
        Long createUserId = shopInfo.getCreateUserId();
        Long updateUserId = shopInfo.getUpdateUserId();
        Set<Long> userIdSet = new HashSet<>();
        userIdSet.add(createUserId);
        userIdSet.add(updateUserId);
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        shopInfoDTO.setCreateUser(userInfoMap.get(createUserId));
        shopInfoDTO.setUpdateUser(userInfoMap.get(updateUserId));
        return shopInfoDTO;
    }

    @Override
    protected List<ShopInfoDTO> toDtoList(List<ShopInfo> list) {
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
            ShopInfoDTO shopInfoDTO = super.toDto(e);
            shopInfoDTO.setCreateUser(userInfoMap.get(e.getCreateUserId()));
            shopInfoDTO.setUpdateUser(userInfoMap.get(e.getUpdateUserId()));
            return shopInfoDTO;
        });
    }

    @Override
    public Class<ShopInfoDTO> getDtoClass() {
        return ShopInfoDTO.class;
    }

}
