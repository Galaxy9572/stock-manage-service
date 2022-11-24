package com.jy.stock.common.validate.annotation;

import com.jy.stock.common.validate.validator.EmailValidator;

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
@Constraint(validatedBy = EmailValidator.class)
public @interface ValidateEmail {

    String message() default "{email.format.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
