package com.jy.stock.common.validate.validator.system;

import com.jy.stock.common.validate.annotation.system.ValidateSubModule;
import com.jy.stock.enums.system.SubModuleEnum;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liaojunyao
 */
public class SubModuleValidator implements ConstraintValidator<ValidateSubModule, String> {

    @Override
    public void initialize(ValidateSubModule constraintAnnotation) {
    }

    @Override
    public boolean isValid(String subModule, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(subModule)) {
            return true;
        }
        return SubModuleEnum.getByCode(subModule) != null;
    }

}