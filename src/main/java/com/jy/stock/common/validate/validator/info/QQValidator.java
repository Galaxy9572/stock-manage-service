package com.jy.stock.common.validate.validator.info;

import com.jy.stock.common.validate.annotation.info.ValidateQQ;
import org.apache.commons.lang3.StringUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author liaojunyao
 */
public class QQValidator implements ConstraintValidator<ValidateQQ, String> {

    private static final Pattern PATTERN = Pattern.compile("\\d+");

    @Override
    public void initialize(ValidateQQ constraintAnnotation) {
    }

    @Override
    public boolean isValid(String qq, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(qq)){
            return true;
        }
        return PATTERN.matcher(qq).matches();
    }

}