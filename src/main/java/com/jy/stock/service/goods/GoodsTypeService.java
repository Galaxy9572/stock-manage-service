package com.jy.stock.service.goods;

import com.jy.stock.dao.entity.goods.GoodsType;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
public interface GoodsTypeService extends IService<GoodsType>{


    int updateBatchSelective(List<GoodsType> list);

    int batchInsert(List<GoodsType> list);

}
