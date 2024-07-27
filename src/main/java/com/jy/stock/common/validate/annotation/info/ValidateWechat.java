package com.jy.stock.common.validate.annotation.info;

import com.jy.stock.common.validate.validator.info.WechatValidator;
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
@Constraint(validatedBy = WechatValidator.class)
public @interface ValidateWechat {

    String message() default "{wechat.format.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
