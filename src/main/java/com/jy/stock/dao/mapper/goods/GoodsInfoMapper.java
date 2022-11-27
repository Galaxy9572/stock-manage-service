package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface GoodsInfoMapper extends BaseMapper<GoodsInfo> {

    IPage<GoodsInfo> listGoodsInfo(@Param("page") Page<GoodsInfo> page, @Param("param") GoodsInfo param);

}