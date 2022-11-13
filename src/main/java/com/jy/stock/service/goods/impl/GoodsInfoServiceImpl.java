package com.jy.stock.service.goods.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import com.jy.stock.dao.mapper.goods.GoodsInfoMapper;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.service.goods.GoodsInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 商品信息服务
 * @author liaojunyao
 */
@Service
public class GoodsInfoServiceImpl extends EnhancedServiceImpl<GoodsInfoMapper, GoodsInfo, GoodsInfoDTO> implements GoodsInfoService{

    @Override
    public int batchInsert(List<GoodsInfo> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<GoodsInfoDTO> getDtoClass() {
        return GoodsInfoDTO.class;
    }
}
