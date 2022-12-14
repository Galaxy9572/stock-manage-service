package com.jy.stock.dao.mapper.goods;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.enums.common.SortOrderEnum;
import com.jy.stock.dao.entity.goods.GoodsUnit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liaojunyao
 */
public interface GoodsUnitMapper extends BaseMapper<GoodsUnit> {
    int batchInsert(@Param("list") List<GoodsUnit> list);

    IPage<GoodsUnit> listGoodsUnits(@Param("page")Page<GoodsUnit> page, @Param("param") GoodsUnit param, @Param("sort")SortOrderEnum sort);
}