package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.goods.GoodsStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsStockMapper extends BaseMapper<GoodsStock> {
    int updateBatchSelective(List<GoodsStock> list);

    int batchInsert(@Param("list") List<GoodsStock> list);
}