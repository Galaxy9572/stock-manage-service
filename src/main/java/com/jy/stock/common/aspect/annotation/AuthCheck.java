package com.jy.stock.common.aspect.annotation;

import com.jy.stock.enums.system.UserRoleEnum;

import java.lang.annotation.*;

/**
 * @author liaojunyao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthCheck {

    boolean needLogin() default true;

    UserRoleEnum[] roles();

}
