package com.jy.stock.common.validate.annotation.system;

import com.jy.stock.common.validate.validator.system.SubModuleValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liaojunyao
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SubModuleValidator.class)
public @interface ValidateSubModule {

    String message() default "{system.operation.sub.module.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
