package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsStock;
import com.jy.stock.pojo.dto.goods.GoodsStockDTO;
import com.jy.stock.pojo.request.goods.ModifyGoodsStockWarningReq;

public interface GoodsStockService extends IService<GoodsStock>{


    GoodsStockDTO modifyGoodsStockWarning(ModifyGoodsStockWarningReq request);

    GoodsStockDTO checkExistenceById(Long id, boolean assertExists);
}
