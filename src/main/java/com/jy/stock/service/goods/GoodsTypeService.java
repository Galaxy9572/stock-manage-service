package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;

import java.util.List;

public interface GoodsTypeService extends IService<GoodsType>{


    Boolean addModifyGoodsType(AddModifyGoodsTypeReq request);

    List<GoodsTypeDTO> listAllGoodsTypes(Long parentTypeId);

    Boolean deleteGoodsType(Long id);
}
