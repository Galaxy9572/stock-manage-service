package com.jy.stock.common.aspect;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.exception.BusinessException;
import com.jy.stock.common.util.ContextHolder;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.enums.user.UserRoleEnum;
import com.jy.stock.pojo.dto.user.UserRoleDTO;
import com.jy.stock.service.user.UserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author liaojunyao
 */
@Aspect
@Component
public class AuthCheckAspect {

    @Resource
    private UserRoleService userRoleService;

    @Pointcut("@annotation(com.jy.stock.common.aspect.annotation.AuthCheck)")
    public void pointCut() {

    }

    @Before(value = "pointCut() && @annotation(authCheck)")
    public void check(AuthCheck authCheck) {
        if (!authCheck.needLogin()) {
            return;
        }
        Long userId = ContextHolder.currentUserId();
        if (userId == null) {
            throw BusinessException.of(HttpStatus.UNAUTHORIZED, "user.not.login");
        }
        UserRoleEnum[] roles = authCheck.roles();
        if (roles == null || roles.length == 0) {
            return;
        }
        List<UserRoleDTO> userRoleDTOList = userRoleService.listByUserId(userId);
        List<UserRoleEnum> userRoleEnums = StreamUtils.mapFilterCollect(userRoleDTOList, e -> UserRoleEnum.getByCode(e.getRoleCode()), Objects::nonNull);
        if (CollectionUtils.isEmpty(userRoleEnums)) {
            throw BusinessException.of(HttpStatus.FORBIDDEN, "permission.denied");
        }
    }

}
