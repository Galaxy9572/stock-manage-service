package com.jy.stock.common.validate.validator.system.operation;

import com.jy.stock.common.validate.annotation.system.operation.ValidateOperationType;
import com.jy.stock.enums.system.operation.OperationTypeEnum;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liaojunyao
 */
public class OperationTypeValidator implements ConstraintValidator<ValidateOperationType, String> {

    @Override
    public void initialize(ValidateOperationType constraintAnnotation) {
    }

    @Override
    public boolean isValid(String operationType, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(operationType)) {
            return true;
        }
        return OperationTypeEnum.getByCode(operationType) != null;
    }

}