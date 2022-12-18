package com.jy.stock.service.system.operation;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.system.operation.OperationLog;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.operation.OperationLogDTO;
import com.jy.stock.pojo.request.system.operation.AddOperationLogReq;
import com.jy.stock.pojo.request.system.operation.QueryOperationLogReq;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liaojunyao
 */
public interface OperationLogService extends IService<OperationLog>{

    @Async
    @Transactional(rollbackFor = Exception.class)
    void addOperationLog(AddOperationLogReq request);

    PageDTO<OperationLogDTO> listOperationLogByPage(QueryOperationLogReq request);
}
