package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.dao.mapper.goods.GoodsTypeMapper;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.service.goods.GoodsTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别服务
 *
 * @author liaojunyao
 */
@Service
public class GoodsTypeServiceImpl extends EnhancedServiceImpl<GoodsTypeMapper, GoodsType, GoodsTypeDTO> implements GoodsTypeService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addModifyGoodsType(AddModifyGoodsTypeReq request) {
        boolean isSuccess;
        if (request.getId() == null) {
            // 新增
            checkExistenceByName(request.getTypeName(), false);

            if (request.getParentTypeId() == null) {
                // 新增大类
                GoodsType goodsType = new GoodsType();
                BeanCopyUtils.copy(request, goodsType);
                long id = IdWorker.getId(goodsType);
                goodsType.setId(id);
                goodsType.setLevel(1);
                goodsType.setPath(id + "");
                isSuccess = save(goodsType);
            } else {
                // 新增子类
                GoodsTypeDTO parentType = checkExistenceById(request.getParentTypeId(), true);
                GoodsType goodsType = new GoodsType();
                BeanCopyUtils.copy(request, goodsType);
                long id = IdWorker.getId(goodsType);
                goodsType.setId(id);
                goodsType.setLevel(parentType.getLevel() + 1);
                goodsType.setPath(getPath(request.getParentTypeId()) + "!" + id);
                isSuccess = save(goodsType);
            }
        } else {
            // 修改
            GoodsTypeDTO goodsType = checkExistenceById(request.getId(), true);
            if (goodsType.getTypeName().equals(request.getTypeName())) {
                return true;
            }
            LambdaUpdateWrapper<GoodsType> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.set(GoodsType::getTypeName, request.getTypeName()).eq(GoodsType::getId, request.getId());
            isSuccess = update(updateWrapper);
        }
        return isSuccess;
    }

    @Override
    public List<GoodsTypeDTO> listAllGoodsTypes(Long parentTypeId) {
        List<GoodsType> goodsTypes = baseMapper.listAllGoodsTypes(parentTypeId);
        if (CollectionUtils.isEmpty(goodsTypes)) {
            return new ArrayList<>();
        }
        List<GoodsTypeDTO> resultList = new ArrayList<>();
        for (GoodsType goodsType : goodsTypes) {
            String[] idPathArray = goodsType.getPath().split("!");
            List<GoodsTypeDTO> currentList = resultList;
            for (String currentIdStr : idPathArray) {
                GoodsTypeDTO node = StreamUtils.findFirst(currentList, e -> e.getId().toString().equals(currentIdStr));
                if (node == null) {
                    GoodsTypeDTO dto = new GoodsTypeDTO();
                    BeanCopyUtils.copy(goodsType, dto);
                    dto.setChildren(new ArrayList<>());
                    currentList.add(dto);
                    currentList = dto.getChildren();
                } else {
                    currentList = node.getChildren();
                }
            }
        }
        return resultList;
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
        return toDto(goodsType);
    }

    @Override
    public GoodsTypeDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsType goodsType = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
        } else {
            AssertUtils.isNull(goodsType, "goods.type.already.exists");
        }
        return toDto(goodsType);
    }

    @Override
    public Class<GoodsTypeDTO> getDtoClass() {
        return GoodsTypeDTO.class;
    }
}
