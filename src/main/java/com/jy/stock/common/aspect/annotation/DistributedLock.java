package com.jy.stock.common.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author liaojunyao
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DistributedLock {

    String lockKey();

    int waitTime() default 3;

    int releaseTime() default -1;

}
