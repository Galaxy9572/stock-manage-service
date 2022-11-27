package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsInfoReq;

public interface GoodsInfoService extends IService<GoodsInfo>{


    GoodsInfoDTO addModifyGoodsInfo(AddModifyGoodsInfoReq request);

    GoodsInfoDTO checkExistenceByName(String goodsName, boolean assertExists);

    GoodsInfoDTO checkExistenceById(Long id, boolean assertExists);
}
