package com.jy.stock.service.goods;

import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;

/**
 * 商品facade
 * @author liaojunyao
 */
public interface GoodsFacadeService {

    GoodsUnitDTO addModifyGoodsUnit(AddModifyGoodsUnitReq req);

    PageDTO<GoodsUnitDTO> listGoodsUnit(QueryGoodsUnitReq request);

    boolean deleteGoodsUnit(Long id);

}
