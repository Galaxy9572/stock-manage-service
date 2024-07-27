package com.jy.stock.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.system.OperationLog;
import com.jy.stock.model.request.system.QueryOperationLogReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface OperationLogMapper extends BaseMapper<OperationLog> {

    IPage<OperationLog> listOperationLogByPage(@Param("page") Page<OperationLog> page, @Param("param") QueryOperationLogReq param);

}