package com.jy.stock.common.validate.annotation.user;

import com.jy.stock.common.validate.annotation.customer.user.ConfirmPasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


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
