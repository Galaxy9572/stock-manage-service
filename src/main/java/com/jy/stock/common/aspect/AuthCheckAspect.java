package com.jy.stock.common.aspect;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.ContextHolder;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.model.dto.system.UserRoleDTO;
import com.jy.stock.service.system.UserRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 切面用于鉴权检查
 * @author liaojunyao
 */
@Aspect
@Component
@Order(0)
public class AuthCheckAspect {

    /**
     * 用户角色服务
     */
    @Autowired
    private UserRoleService userRoleService;

    /**
     * 定义切入点
     */
    @Pointcut("@annotation(com.jy.stock.common.aspect.annotation.AuthCheck)")
    public void pointCut() {

    }

    /**
     * 检查用户是否有足够的权限访问请求的方法
     * @param point 切入点
     * @param authCheck 鉴权注解
     * @return 调用切入点的返回值
     * @throws Throwable 抛出异常
     */
    @Around(value = "pointCut() && @annotation(authCheck)")
    public Object check(ProceedingJoinPoint point, AuthCheck authCheck) throws Throwable {
        if (authCheck.needLogin()) {
            // 获取当前用户的ID
            Long userId = ContextHolder.currentUserId();
            // 判断用户是否已登录
            AssertUtils.isNotNull(userId, HttpStatus.UNAUTHORIZED, "user.not.login");
            // 获取鉴权注解中要求的角色集合
            Set<UserRoleEnum> roles = Arrays.stream(authCheck.roles()).collect(Collectors.toSet());
            // 如果鉴权注解中没有指定角色，则不需要进行权限检查
            if (CollectionUtils.isNotEmpty(roles)) {
                // 获取当前用户的角色集合
                List<UserRoleDTO> userRoleDTOList = userRoleService.listByUserId(userId);
                // 将UserRoleDTO转化为UserRoleEnum，并过滤掉转化失败的项，最后转化为角色集合
                Set<UserRoleEnum> userRoleEnums = StreamUtils.mapFilterCollectToSet(userRoleDTOList, e -> UserRoleEnum.getByCode(e.getRoleCode()), Objects::nonNull);
                // 检查用户是否具有所需的所有角色
                AssertUtils.isNotEmpty(userRoleEnums, HttpStatus.FORBIDDEN, "permission.denied");
                AssertUtils.isTrue(roles.containsAll(userRoleEnums), HttpStatus.FORBIDDEN, "permission.denied");
            }
        }
        return point.proceed();
    }

}
