package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {
    int batchInsert(@Param("list") List<GoodsInfo> list);
}