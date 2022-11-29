package com.jy.stock.common.validate.validator.goods;

import com.jy.stock.common.validate.annotation.goods.ValidateWholesalePrice;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

/**
 * @author liaojunyao
 */
public class WholesalePriceValidator implements ConstraintValidator<ValidateWholesalePrice, BigDecimal> {

    @Override
    public void initialize(ValidateWholesalePrice constraintAnnotation) {
    }

    @Override
    public boolean isValid(BigDecimal price, ConstraintValidatorContext constraintValidatorContext) {
        if(price == null) {
            return true;
        }
        return price.compareTo(BigDecimal.ZERO) >= 0;
    }

}