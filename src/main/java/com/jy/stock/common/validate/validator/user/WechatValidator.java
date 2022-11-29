package com.jy.stock.common.validate.validator.user;

import com.jy.stock.common.validate.annotation.user.ValidateWechat;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author liaojunyao
 */
public class WechatValidator implements ConstraintValidator<ValidateWechat, String> {

    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z0-9_-]+");

    @Override
    public void initialize(ValidateWechat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String wechat, ConstraintValidatorContext constraintValidatorContext) {
        if(StringUtils.isBlank(wechat)){
            return true;
        }
        return PATTERN.matcher(wechat).matches();
    }

}