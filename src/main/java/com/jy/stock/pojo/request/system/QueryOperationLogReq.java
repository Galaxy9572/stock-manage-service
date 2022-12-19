package com.jy.stock.pojo.request.system;

import com.jy.stock.common.validate.annotation.system.ValidateModule;
import com.jy.stock.common.validate.annotation.system.ValidateOperationType;
import com.jy.stock.common.validate.annotation.system.ValidateSubModule;
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
