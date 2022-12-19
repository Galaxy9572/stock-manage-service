package com.jy.stock.common.validate.annotation.system;

import com.jy.stock.common.validate.validator.system.OperationTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liaojunyao
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OperationTypeValidator.class)
public @interface ValidateOperationType {

    String message() default "{system.operation.type.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
