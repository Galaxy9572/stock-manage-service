package com.jy.stock.pojo.request.system.operation;

import com.jy.stock.enums.system.operation.ModuleEnum;
import com.jy.stock.enums.system.operation.OperationTypeEnum;
import com.jy.stock.enums.system.operation.SubModuleEnum;
import lombok.Data;
import org.springframework.web.context.request.RequestAttributes;

/**
 * @author liaojunyao
 */
@Data
public class AddOperationLogReq {

    private ModuleEnum module;

    private SubModuleEnum subModule;

    private OperationTypeEnum type;

    private Long businessId;

    private Long userId;

    private String desc;

    private RequestAttributes requestAttributes;

}
