package com.jy.stock.model.request.system;

import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
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
