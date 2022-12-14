package com.jy.stock.common.validate.validator.customer;

import com.jy.stock.common.validate.annotation.customer.ValidateEmail;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author liaojunyao
 */
public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {

    private static final Pattern PATTERN = Pattern.compile("[\\w_\\-.]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)");

    @Override
    public void initialize(ValidateEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(email)){
            return true;
        }
        return PATTERN.matcher(email).matches();
    }

}