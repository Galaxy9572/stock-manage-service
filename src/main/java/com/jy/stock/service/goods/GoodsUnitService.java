package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsUnit;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;

import java.util.Collection;
import java.util.Map;

/**
 * @author liaojunyao
 */
public interface GoodsUnitService extends IService<GoodsUnit>{


    GoodsUnitDTO addModifyGoodsUnit(AddModifyGoodsUnitReq req);

    PageDTO<GoodsUnitDTO> listGoodsUnit(QueryGoodsUnitReq request);

    boolean deleteGoodsUnit(Long id);

    GoodsUnitDTO checkExistenceByName(String unitName, boolean assertExists);

    GoodsUnitDTO checkExistenceById(Long id, boolean assertExists);

    GoodsUnitDTO getGoodsUnitById(Long id);

    Map<Long, GoodsUnitDTO> batchListGoodsUnit(Collection<Long> ids);
}
