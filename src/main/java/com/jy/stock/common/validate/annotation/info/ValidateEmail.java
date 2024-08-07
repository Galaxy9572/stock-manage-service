package com.jy.stock.common.validate.annotation.info;

import com.jy.stock.common.validate.validator.info.EmailValidator;

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
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidateEmail {

    String message() default "{email.format.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
