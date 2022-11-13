package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.goods.GoodsUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsUnitMapper extends BaseMapper<GoodsUnit> {
    int batchInsert(@Param("list") List<GoodsUnit> list);
}