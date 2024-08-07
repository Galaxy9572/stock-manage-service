package com.jy.stock.common.validate.validator.system;

import com.jy.stock.common.validate.annotation.system.ValidateConfirmPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;


/**
 * @author liaojunyao
 */
public class ConfirmPasswordValidator implements ConstraintValidator<ValidateConfirmPassword, Object> {

    private String password;
    private String confirmPassword;

    @Override
    public void initialize(ValidateConfirmPassword constraintAnnotation) {
        password = constraintAnnotation.password();
        confirmPassword = constraintAnnotation.confirmPassword();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        try {
            String firstObj = BeanUtils.getProperty(value, password);
            String secondObj = BeanUtils.getProperty(value, confirmPassword);
            if(StringUtils.isBlank(firstObj) && StringUtils.isBlank(secondObj)) {
                return true;
            }
            return StringUtils.equals(firstObj, secondObj);
        } catch (final Exception ignore) {
            return false;
        }
    }

}