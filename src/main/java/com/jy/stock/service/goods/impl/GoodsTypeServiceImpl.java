package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.dao.mapper.goods.GoodsTypeMapper;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类别服务
 * @author liaojunyao
 */
@Service
public class GoodsTypeServiceImpl extends EnhancedServiceImpl<GoodsTypeMapper, GoodsType, GoodsTypeDTO> implements GoodsTypeService{

    @Override
    public Boolean addModifyGoodsType(AddModifyGoodsTypeReq request) {
        boolean isSuccess;
        if (request.getId() == null) {
            // 新增
            LambdaQueryWrapper<GoodsType> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(GoodsType::getTypeName, request.getTypeName());
            long count = count(queryWrapper);
            AssertUtils.isTrue(count == 0, "goods.type.already.exists");

            if (request.getParentTypeId() == null) {
                // 新增大类
                GoodsType goodsType = new GoodsType();
                BeanCopyUtils.copy(request, goodsType);
                goodsType.setLevel(1);
                isSuccess = save(goodsType);
            } else {
                // 新增子类
                GoodsType parentType = getById(request.getParentTypeId());
                AssertUtils.isNotNull(parentType, "goods.type.already.exists");
                GoodsType goodsType = new GoodsType();
                BeanCopyUtils.copy(request, goodsType);
                goodsType.setLevel(parentType.getLevel() + 1);
                isSuccess = save(goodsType);
            }
        } else {
            // 修改
            GoodsType goodsType = getById(request.getId());
            AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
            if(goodsType.getTypeName().equals(request.getTypeName())) {
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


        return null;
    }

    @Override
    public Boolean deleteGoodsType(Long id) {
        GoodsType goodsType = getById(id);
        AssertUtils.isNotNull(goodsType, "goods.type.not.exist");
        return removeById(id);
    }

    @Override
    public Class<GoodsTypeDTO> getDtoClass() {
        return GoodsTypeDTO.class;
    }
}
