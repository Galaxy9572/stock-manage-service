package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.dao.entity.goods.GoodsUnit;
import com.jy.stock.dao.mapper.goods.GoodsUnitMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;
import com.jy.stock.service.goods.GoodsUnitService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 商品计量单位管理
 * @author liaojunyao
 */
@Service
public class GoodsUnitServiceImpl extends EnhancedServiceImpl<GoodsUnitMapper, GoodsUnit, GoodsUnitDTO> implements GoodsUnitService{

    @Override
    public GoodsUnitDTO addModifyGoodsUnit(AddModifyGoodsUnitReq req){
        LambdaQueryWrapper<GoodsUnit> wrapper = new LambdaQueryWrapper<>();
        if(req.getId() != null){
            GoodsUnitDTO goodsUnitDTO = checkExistenceById(req.getId(), true);
            // 值有变化才修改
            if(!(StringUtils.equals(req.getUnitName(), goodsUnitDTO.getUnitName())
                    && goodsUnitDTO.getAllowDecimal().equals(req.getAllowDecimal()))){
                LambdaUpdateWrapper<GoodsUnit> updateWrapper = new LambdaUpdateWrapper<>();
                updateWrapper.eq(GoodsUnit::getId, req.getId());
                if (!goodsUnitDTO.getUnitName().equals(req.getUnitName())) {
                    wrapper.eq(GoodsUnit::getUnitName, req.getUnitName());
                    GoodsUnit goodsUnit = getOne(wrapper);
                    AssertUtils.isTrue(!goodsUnit.getId().equals(req.getId()), "goods.unit.already.exists");
                    updateWrapper.set(GoodsUnit::getUnitName, req.getUnitName());
                }
                if (!goodsUnitDTO.getAllowDecimal().equals(req.getAllowDecimal())) {
                    updateWrapper.set(GoodsUnit::getAllowDecimal, req.getAllowDecimal());
                }
                update(null, updateWrapper);
            }
        }else{
            wrapper.eq(GoodsUnit::getUnitName, req.getUnitName());
            GoodsUnit goodsUnit = getOne(wrapper);
            AssertUtils.isNull(goodsUnit, "goods.unit.already.exists");
            GoodsUnit newUnit = new GoodsUnit();
            newUnit.setUnitName(req.getUnitName());
            newUnit.setAllowDecimal(req.getAllowDecimal());
            save(newUnit);
        }
        wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(GoodsUnit::getUnitName, req.getUnitName());
        GoodsUnit goodsUnit = getOne(wrapper);
        return toDto(goodsUnit);
    }

    @Override
    public PageDTO<GoodsUnitDTO> listGoodsUnit(QueryGoodsUnitReq request){
        Page<GoodsUnit> page = new Page<>(request.getPageNo(), request.getPageSize());
        GoodsUnit param = new GoodsUnit();
        param.setUnitName(request.getUnitName());
        IPage<GoodsUnit> pageResult = baseMapper.listGoodsUnits(page, param, request.getSortOrder());
        return toPageDTO(pageResult);
    }

    @Override
    public boolean deleteGoodsUnit(Long id){
        GoodsUnit goodsUnit = getById(id);
        AssertUtils.isNotNull(goodsUnit, "goods.unit.not.exist");
        return removeById(id);
    }

    @Override
    public GoodsUnitDTO checkExistenceByName(String unitName, boolean assertExists) {
        LambdaQueryWrapper<GoodsUnit> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsUnit::getUnitName, unitName);
        GoodsUnit goodsUnit = getOne(queryWrapper);
        if (assertExists) {
            AssertUtils.isNotNull(goodsUnit, "goods.unit.not.exist");
        } else {
            AssertUtils.isNull(goodsUnit, "goods.unit.already.exists");
        }
        return goodsUnit != null ? toDto(goodsUnit) : null;
    }

    @Override
    public GoodsUnitDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsUnit goodsUnit = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsUnit, "goods.unit.not.exist");
        } else {
            AssertUtils.isNull(goodsUnit, "goods.unit.already.exists");
        }
        return goodsUnit != null ? toDto(goodsUnit) : null;
    }

    @Override
    public GoodsUnitDTO getGoodsUnitById(Long id) {
        GoodsUnit goodsUnit = getById(id);
        if (goodsUnit == null) {
            return null;
        } else {
            return toDto(goodsUnit);
        }
    }

    @Override
    public Class<GoodsUnitDTO> getDtoClass() {
        return GoodsUnitDTO.class;
    }
}
