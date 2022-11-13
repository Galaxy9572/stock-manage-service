package com.jy.stock.service.goods.impl;

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

}
