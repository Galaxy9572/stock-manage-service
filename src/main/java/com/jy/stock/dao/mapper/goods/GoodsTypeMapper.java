package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.goods.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {
    int updateBatchSelective(List<GoodsType> list);

    int batchInsert(@Param("list") List<GoodsType> list);
}