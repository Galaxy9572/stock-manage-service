package com.jy.stock.common.validate.validator.system.operation;

import com.jy.stock.common.validate.annotation.system.operation.ValidateSubModule;
import com.jy.stock.enums.system.operation.SubModuleEnum;
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