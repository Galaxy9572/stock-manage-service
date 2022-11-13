package com.jy.stock.service.goods.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.goods.GoodsUnit;
import com.jy.stock.dao.mapper.goods.GoodsUnitMapper;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.service.goods.GoodsUnitService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsUnitServiceImpl extends EnhancedServiceImpl<GoodsUnitMapper, GoodsUnit, GoodsUnitDTO> implements GoodsUnitService{

    @Override
    public int batchInsert(List<GoodsUnit> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<GoodsUnitDTO> getDtoClass() {
        return GoodsUnitDTO.class;
    }
}
