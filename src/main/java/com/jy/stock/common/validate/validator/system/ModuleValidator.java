package com.jy.stock.common.validate.validator.system;

import com.jy.stock.common.validate.annotation.system.ValidateModule;
import com.jy.stock.enums.system.ModuleEnum;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liaojunyao
 */
public class ModuleValidator implements ConstraintValidator<ValidateModule, String> {

    @Override
    public void initialize(ValidateModule constraintAnnotation) {
    }

    @Override
    public boolean isValid(String module, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(module)) {
            return true;
        }
        return ModuleEnum.getByCode(module) != null;
    }

}