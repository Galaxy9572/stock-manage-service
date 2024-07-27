package com.jy.stock.service.system;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.system.OperationLog;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.system.OperationLogDTO;
import com.jy.stock.model.request.system.AddOperationLogReq;
import com.jy.stock.model.request.system.QueryOperationLogReq;
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
