package com.jy.stock.common.aspect;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.ContextHolder;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.pojo.dto.system.UserRoleDTO;
import com.jy.stock.service.system.UserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author liaojunyao
 */
@Aspect
@Component
@Order(0)
public class AuthCheckAspect {

    @Resource
    private UserRoleService userRoleService;

    @Pointcut("@annotation(com.jy.stock.common.aspect.annotation.AuthCheck)")
    public void pointCut() {

    }

    @Around(value = "pointCut() && @annotation(authCheck)")
    public Object check(ProceedingJoinPoint point, AuthCheck authCheck) throws Throwable {
        if (authCheck.needLogin()) {
            Long userId = ContextHolder.currentUserId();
            AssertUtils.isNotNull(userId, HttpStatus.UNAUTHORIZED, "user.not.login");
            Set<UserRoleEnum> roles = Arrays.stream(authCheck.roles()).collect(Collectors.toSet());
            if (CollectionUtils.isNotEmpty(roles)) {
                List<UserRoleDTO> userRoleDTOList = userRoleService.listByUserId(userId);
                Set<UserRoleEnum> userRoleEnums = StreamUtils.mapFilterCollectToSet(userRoleDTOList, e -> UserRoleEnum.getByCode(e.getRoleCode()), Objects::nonNull);
                AssertUtils.isNotEmpty(userRoleEnums, HttpStatus.FORBIDDEN, "permission.denied");
                AssertUtils.isTrue(roles.containsAll(userRoleEnums), HttpStatus.FORBIDDEN, "permission.denied");
            }
        }
        return point.proceed();
    }

}
