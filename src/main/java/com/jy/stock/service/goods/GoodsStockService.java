package com.jy.stock.service.goods;

import com.jy.stock.dao.entity.goods.GoodsStock;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
public interface GoodsStockService extends IService<GoodsStock>{


    int updateBatchSelective(List<GoodsStock> list);

    int batchInsert(List<GoodsStock> list);

}
