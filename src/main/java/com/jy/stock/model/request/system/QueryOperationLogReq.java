package com.jy.stock.model.request.system;

import com.jy.stock.common.validate.annotation.system.ValidateModule;
import com.jy.stock.common.validate.annotation.system.ValidateOperationType;
import com.jy.stock.common.validate.annotation.system.ValidateSubModule;
import com.jy.stock.model.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QueryOperationLogReq extends PageRequest {

    @ValidateModule
    private String module;

    @ValidateSubModule
    private String subModule;

    @ValidateOperationType
    private String operationType;

    private LocalDateTime operationStartTime;

    private LocalDateTime operationEndTime;

    private Long operateUserId;

}
