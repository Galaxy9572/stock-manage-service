package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.goods.GoodsType;
import com.jy.stock.model.dto.goods.GoodsTypeDTO;
import com.jy.stock.model.request.goods.AddModifyGoodsTypeReq;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface GoodsTypeService extends IService<GoodsType>{


    GoodsTypeDTO addModifyGoodsType(AddModifyGoodsTypeReq request);

    List<GoodsTypeDTO> listAllGoodsTypes(Long parentTypeId);

    Boolean deleteGoodsType(Long id);

    GoodsTypeDTO checkExistenceByName(String typeName, boolean assertExists);

    GoodsTypeDTO checkExistenceById(Long id, boolean assertExists);

    GoodsTypeDTO getGoodsTypeById(Long id);

    Map<Long, GoodsTypeDTO> batchListGoodsType(Collection<Long> ids);
}
