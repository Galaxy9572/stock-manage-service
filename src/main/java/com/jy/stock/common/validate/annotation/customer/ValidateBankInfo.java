package com.jy.stock.common.validate.annotation.customer;

import com.jy.stock.common.validate.validator.customer.BankInfoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liaojunyao
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BankInfoValidator.class)
public @interface ValidateBankInfo {

    String message() default "{customer.bank.info.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String bankName() default "bankName";

    String bankCardId() default "bankCardId";

    String taxpayerId() default "taxpayerId";

}
