package com.jy.stock.service.goods.impl;

import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;
import com.jy.stock.service.goods.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liaojunyao
 */
@Service
@Slf4j
public class GoodsFacadeServiceImpl implements GoodsFacadeService {

    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private GoodsStockService goodsStockService;

    @Resource
    private GoodsUnitService goodsUnitService;

    @Resource
    private GoodsTypeService goodsTypeService;

    @Override
    public GoodsUnitDTO addModifyGoodsUnit(AddModifyGoodsUnitReq req){
        return goodsUnitService.addModifyGoodsUnit(req);
    }

    @Override
    public PageDTO<GoodsUnitDTO> listGoodsUnit(QueryGoodsUnitReq request){
        return goodsUnitService.listGoodsUnit(request);
    }

}
