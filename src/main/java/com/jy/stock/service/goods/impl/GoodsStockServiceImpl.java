package com.jy.stock.service.goods.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.dao.entity.goods.GoodsStock;
import com.jy.stock.dao.mapper.goods.GoodsStockMapper;
import com.jy.stock.pojo.dto.goods.GoodsStockDTO;
import com.jy.stock.pojo.request.goods.ModifyGoodsStockWarningReq;
import com.jy.stock.service.goods.GoodsInfoService;
import com.jy.stock.service.goods.GoodsStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品库存服务
 * @author liaojunyao
 */
@Service
public class GoodsStockServiceImpl extends EnhancedServiceImpl<GoodsStockMapper, GoodsStock, GoodsStockDTO> implements GoodsStockService{

    @Resource
    private GoodsInfoService goodsInfoService;

    @Override
    public GoodsStockDTO modifyGoodsStockWarning(ModifyGoodsStockWarningReq request) {
        GoodsStockDTO goodsStockDTO = checkExistenceById(request.getId(), true);
        goodsInfoService.checkExistenceById(goodsStockDTO.getGoodsId(), true);
        GoodsStock updateEntity = new GoodsStock();
        updateEntity.setId(request.getId());
        updateEntity.setAllowStockWarning(request.getAllowStockWarning());
        updateEntity.setMinStockNum(request.getMinStockNum());
        updateEntity.setMaxStockNum(request.getMaxStockNum());
        boolean isSuccess = updateById(updateEntity);
        AssertUtils.isTrue(isSuccess, "operate.failed");
        return toDto(getById(request.getId()));
    }

    @Override
    public GoodsStockDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsStock goodsStock = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsStock, "goods.stock.not.exist");
        } else {
            AssertUtils.isNull(goodsStock, "goods.stock.already.exists");
        }
        return goodsStock != null ? toDto(goodsStock) : null;
    }

    @Override
    public Class<GoodsStockDTO> getDtoClass() {
        return GoodsStockDTO.class;
    }
}
