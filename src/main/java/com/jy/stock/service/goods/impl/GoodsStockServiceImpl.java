package com.jy.stock.service.goods.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.goods.GoodsStock;
import com.jy.stock.dao.mapper.goods.GoodsStockMapper;
import com.jy.stock.pojo.dto.goods.GoodsStockDTO;
import com.jy.stock.service.goods.GoodsStockService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品库存服务
 * @author liaojunyao
 */
@Service
public class GoodsStockServiceImpl extends EnhancedServiceImpl<GoodsStockMapper, GoodsStock, GoodsStockDTO> implements GoodsStockService{
    @Override
    public Class<GoodsStockDTO> getDtoClass() {
        return GoodsStockDTO.class;
    }
}
