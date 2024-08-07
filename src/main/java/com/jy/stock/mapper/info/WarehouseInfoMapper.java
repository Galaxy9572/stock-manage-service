package com.jy.stock.mapper.info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.info.WarehouseInfo;
import com.jy.stock.model.request.info.QueryWarehouseInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface WarehouseInfoMapper extends BaseMapper<WarehouseInfo> {

    IPage<WarehouseInfo> listWarehouseInfoByPage(@Param("page") Page<WarehouseInfo> pageParam, @Param("param") QueryWarehouseInfoReq param);

}