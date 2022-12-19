package com.jy.stock.dao.mapper.info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.info.SupplierInfo;
import com.jy.stock.pojo.request.info.QuerySupplierInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface SupplierInfoMapper extends BaseMapper<SupplierInfo> {

    Page<SupplierInfo> listSupplierInfoByPage(@Param("page") Page<SupplierInfo> pageParam, @Param("param") QuerySupplierInfoReq request);

}