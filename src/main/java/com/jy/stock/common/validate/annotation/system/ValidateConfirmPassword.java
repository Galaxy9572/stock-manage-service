package com.jy.stock.common.validate.annotation.system;

import com.jy.stock.common.validate.validator.system.ConfirmPasswordValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author liaojunyao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConfirmPasswordValidator.class)
public @interface ValidateConfirmPassword {

    String message() default "{password.not.consistent}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String password() default "password";

    String confirmPassword() default "confirmPassword";

}
