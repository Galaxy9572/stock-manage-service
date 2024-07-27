package com.jy.stock.common.validate.validator.system;

import com.jy.stock.common.response.CodeDescVO;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.validate.annotation.system.ValidateUserRole;
import com.jy.stock.enums.system.UserRoleEnum;
import org.springframework.util.CollectionUtils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Set;

/**
 * @author liaojunyao
 */
public class UserRoleValidator implements ConstraintValidator<ValidateUserRole, List<String>> {

    private Set<String> roleSet;

    @Override
    public void initialize(ValidateUserRole constraintAnnotation) {
        roleSet = StreamUtils.mapCollectToSet(UserRoleEnum.listAllRoles(), CodeDescVO::getCode);
    }

    @Override
    public boolean isValid(List<String> roles, ConstraintValidatorContext constraintValidatorContext) {
        if(CollectionUtils.isEmpty(roles)){
            return true;
        }
        return StreamUtils.allMatch(roles, roleSet::contains);
    }

}