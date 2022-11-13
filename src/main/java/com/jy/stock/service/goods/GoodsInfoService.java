package com.jy.stock.service.goods;

import java.util.List;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import com.baomidou.mybatisplus.extension.service.IService;
public interface GoodsInfoService extends IService<GoodsInfo>{


    int batchInsert(List<GoodsInfo> list);

}
