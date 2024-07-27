package com.jy.stock.common.validate.annotation.system;

import com.jy.stock.common.validate.validator.system.ModuleValidator;

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
@Constraint(validatedBy = ModuleValidator.class)
public @interface ValidateModule {

    String message() default "{system.operation.module.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
