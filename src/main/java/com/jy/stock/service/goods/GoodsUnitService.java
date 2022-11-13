package com.jy.stock.service.goods;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.goods.GoodsUnit;

import java.util.List;
/**
 * @author liaojunyao
 */
public interface GoodsUnitService extends IService<GoodsUnit>{

    int batchInsert(List<GoodsUnit> list);

}
