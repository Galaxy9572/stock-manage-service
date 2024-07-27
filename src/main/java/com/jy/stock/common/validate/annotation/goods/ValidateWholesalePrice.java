package com.jy.stock.common.validate.annotation.goods;

import com.jy.stock.common.validate.validator.goods.WholesalePriceValidator;

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
@Constraint(validatedBy = WholesalePriceValidator.class)
public @interface ValidateWholesalePrice {

    String message() default "{goods.price.must.greater.than.zero}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
