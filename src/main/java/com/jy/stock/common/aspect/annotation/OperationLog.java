package com.jy.stock.common.aspect.annotation;

import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;

import java.lang.annotation.*;

/**
 * @author liaojunyao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationLog {

    ModuleEnum module();

    SubModuleEnum subModule();

    OperationTypeEnum operationType();

}
