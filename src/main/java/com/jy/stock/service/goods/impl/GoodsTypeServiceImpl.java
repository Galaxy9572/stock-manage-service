package com.jy.stock.service.goods.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.dao.mapper.goods.GoodsTypeMapper;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类别服务
 * @author liaojunyao
 */
@Service
public class GoodsTypeServiceImpl extends EnhancedServiceImpl<GoodsTypeMapper, GoodsType, GoodsTypeDTO> implements GoodsTypeService{

    @Override
    public int updateBatchSelective(List<GoodsType> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<GoodsType> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<GoodsTypeDTO> getDtoClass() {
        return GoodsTypeDTO.class;
    }
}
