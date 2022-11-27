package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsInfoReq;
import com.jy.stock.pojo.request.goods.QueryGoodsInfoReq;

public interface GoodsInfoService extends IService<GoodsInfo>{


    GoodsInfoDTO addModifyGoodsInfo(AddModifyGoodsInfoReq request);

    PageDTO<GoodsInfoDTO> listGoodsInfo(QueryGoodsInfoReq request);

    GoodsInfoDTO getGoodsInfoDetail(Long id);

    boolean deleteGoodsInfo(Long id);

    GoodsInfoDTO checkExistenceByName(String goodsName, boolean assertExists);

    GoodsInfoDTO checkExistenceById(Long id, boolean assertExists);
}
