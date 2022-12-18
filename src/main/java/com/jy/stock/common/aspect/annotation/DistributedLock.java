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

    int waitTime();

    int releaseTime() default -1;

}
