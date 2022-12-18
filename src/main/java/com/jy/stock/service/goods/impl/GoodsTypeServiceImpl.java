package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.dao.mapper.goods.GoodsTypeMapper;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.service.goods.GoodsTypeService;
import com.jy.stock.service.system.user.UserInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * 商品类别服务
 *
 * @author liaojunyao
 */
@Service
public class GoodsTypeServiceImpl extends EnhancedServiceImpl<GoodsTypeMapper, GoodsType, GoodsTypeDTO> implements GoodsTypeService {

    @Resource
    private UserInfoService userInfoService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public GoodsTypeDTO addModifyGoodsType(AddModifyGoodsTypeReq request) {
        boolean isSuccess;
        GoodsTypeDTO result;
        if (request.getId() == null) {
            // 新增
            checkExistenceByName(request.getTypeName(), false);
            GoodsType goodsType = new GoodsType();
            long id = IdWorker.getId(goodsType);
            if (request.getParentTypeId() == null) {
                // 新增大类
                BeanCopyUtils.copy(request, goodsType);
                goodsType.setId(id);
                goodsType.setLevel(1);
                goodsType.setPath(id + "");
            } else {
                // 新增子类
                GoodsTypeDTO parentType = checkExistenceById(request.getParentTypeId(), true);
                BeanCopyUtils.copy(request, goodsType);
                goodsType.setId(id);
                goodsType.setLevel(parentType.getLevel() + 1);
                goodsType.setPath(getPath(request.getParentTypeId()) + "!" + id);
            }
            isSuccess = save(goodsType);
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return getGoodsTypeById(id);
        } else {
            // 修改
            GoodsTypeDTO goodsType = checkExistenceById(request.getId(), true);
            if (goodsType.getTypeName().equals(request.getTypeName())) {
                return goodsType;
            }
            GoodsType updateEntity = new GoodsType();
            updateEntity.setId(request.getId());
            updateEntity.setTypeName(request.getTypeName());
            isSuccess = updateById(updateEntity);
            AssertUtils.isTrue(isSuccess, "operate.failed");
            return getGoodsTypeById(request.getId());
        }
    }

    @Override
    public List<GoodsTypeDTO> listAllGoodsTypes(Long parentTypeId) {
        List<GoodsType> goodsTypes = baseMapper.listAllGoodsTypes(parentTypeId);
        if (CollectionUtils.isEmpty(goodsTypes)) {
            return new ArrayList<>();
        }
        Set<Long> userIdSet = new HashSet<>();
        goodsTypes.forEach(u -> {
            userIdSet.add(u.getCreateUserId());
            userIdSet.add(u.getUpdateUserId());
        });
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        return StreamUtils.mapCollect(goodsTypes, e -> {
            GoodsTypeDTO dto = new GoodsTypeDTO();
            BeanCopyUtils.copy(e, dto);
            dto.setCreateUser(userInfoMap.get(e.getCreateUserId()));
            dto.setUpdateUser(userInfoMap.get(e.getUpdateUserId()));
            return dto;
        });
    }

    @Override
    public Boolean deleteGoodsType(Long id) {
        GoodsType goodsType = getById(id);
        AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
        List<Long> childrenIds = baseMapper.getChildren(id);
        return removeBatchByIds(childrenIds);
    }

    public String getPath(Long id) {
        List<Long> ids = baseMapper.getParents(id);
        return StringUtils.join(ids, "!");
    }

    @Override
    public GoodsTypeDTO checkExistenceByName(String typeName, boolean assertExists) {
        LambdaQueryWrapper<GoodsType> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsType::getTypeName, typeName);
        GoodsType goodsType = getOne(queryWrapper);
        if (assertExists) {
            AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
        } else {
            AssertUtils.isNull(goodsType, "goods.type.already.exists");
        }
        return goodsType != null ? toDto(goodsType) : null;
    }

    @Override
    public GoodsTypeDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsType goodsType = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
        } else {
            AssertUtils.isNull(goodsType, "goods.type.already.exists");
        }
        return goodsType != null ? toDto(goodsType) : null;
    }

    @Override
    public GoodsTypeDTO getGoodsTypeById(Long id) {
        GoodsType goodsType = getById(id);
        if (goodsType == null) {
            return null;
        } else {
            return toDto(goodsType);
        }
    }

    @Override
    public Map<Long, GoodsTypeDTO> batchListGoodsType(Collection<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return new HashMap<>(0);
        }
        List<GoodsType> goodsTypes = listByIds(ids);
        List<GoodsTypeDTO> dtoList = StreamUtils.mapCollect(goodsTypes, this::toDto);
        return StreamUtils.toMap(dtoList, GoodsTypeDTO::getId, e -> e);
    }

    @Override
    public Class<GoodsTypeDTO> getDtoClass() {
        return GoodsTypeDTO.class;
    }
}
