package com.jy.stock.pojo.request.system.operation;

import com.jy.stock.common.validate.annotation.system.operation.ValidateModule;
import com.jy.stock.common.validate.annotation.system.operation.ValidateOperationType;
import com.jy.stock.common.validate.annotation.system.operation.ValidateSubModule;
import com.jy.stock.pojo.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private Date operationStartTime;

    private Date operationEndTime;

    private Long operateUserId;

}
