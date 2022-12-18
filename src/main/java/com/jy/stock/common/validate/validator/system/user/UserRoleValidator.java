package com.jy.stock.common.validate.validator.system.user;

import com.jy.stock.enums.system.user.UserRoleEnum;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.validate.annotation.system.user.ValidateUserRole;
import com.jy.stock.pojo.response.system.user.UserRoleEnumVO;
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