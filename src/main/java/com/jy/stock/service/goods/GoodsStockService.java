package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.goods.GoodsStock;
import com.jy.stock.model.dto.goods.GoodsStockDTO;
import com.jy.stock.model.request.goods.ModifyGoodsStockWarningReq;

public interface GoodsStockService extends IService<GoodsStock>{


    GoodsStockDTO modifyGoodsStockWarning(ModifyGoodsStockWarningReq request);

    GoodsStockDTO checkExistenceById(Long id, boolean assertExists);
}
