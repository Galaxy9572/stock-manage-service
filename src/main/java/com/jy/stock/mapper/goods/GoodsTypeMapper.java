package com.jy.stock.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.model.entity.goods.GoodsType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsTypeMapper extends BaseMapper<GoodsType> {

    List<GoodsType> listAllGoodsTypes(@Param("parentTypeId") Long parentTypeId);

    List<Long> getParents(@Param("id") Long id);

    List<Long> getChildren(@Param("id") Long id);

}