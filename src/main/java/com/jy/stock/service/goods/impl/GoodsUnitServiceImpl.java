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
            wrapper.eq(GoodsUnit::getId, req.getId());
            GoodsUnit goodsUnit = getOne(wrapper);
            AssertUtils.isNotNull(goodsUnit, "goods.unit.not.exists");

            LambdaUpdateWrapper<GoodsUnit> updateWrapper = new LambdaUpdateWrapper<>();
            updateWrapper.set(GoodsUnit::getUnitName, req.getUnitName()).eq(GoodsUnit::getId, req.getId());
            update(null, updateWrapper);
        }else{
            wrapper.eq(GoodsUnit::getUnitName, req.getUnitName());
            GoodsUnit goodsUnit = getOne(wrapper);
            AssertUtils.isNull(goodsUnit, "goods.unit.already.exists");
            GoodsUnit newUnit = new GoodsUnit();
            newUnit.setUnitName(req.getUnitName());
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
    public Class<GoodsUnitDTO> getDtoClass() {
        return GoodsUnitDTO.class;
    }
}
