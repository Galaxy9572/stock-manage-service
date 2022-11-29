package com.jy.stock.common.validate.validator.user;

import com.jy.stock.common.enums.UserRoleEnum;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.validate.annotation.user.ValidateUserRole;
import com.jy.stock.pojo.response.user.UserRoleEnumVO;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Set;

/**
 * @author liaojunyao
 */
public class UserRoleValidator implements ConstraintValidator<ValidateUserRole, List<String>> {

    private Set<String> roleSet;

    @Override
    public void initialize(ValidateUserRole constraintAnnotation) {
        roleSet = StreamUtils.mapCollectToSet(UserRoleEnum.listAllRoles(), UserRoleEnumVO::getCode);
    }

    @Override
    public boolean isValid(List<String> roles, ConstraintValidatorContext constraintValidatorContext) {
        if(CollectionUtils.isEmpty(roles)){
            return true;
        }
        return StreamUtils.allMatch(roles, roleSet::contains);
    }

}