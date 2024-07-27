package com.jy.stock.common.aspect;

import com.jy.stock.common.aspect.annotation.DistributedLock;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.DistributedLocker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author liaojunyao
 */
@Aspect
@Component
@Slf4j
public class DistributedLockAspect {

    @Autowired
    private DistributedLocker locker;

    @Pointcut("@annotation(com.jy.stock.common.aspect.annotation.DistributedLock)")
    public void pointCut() {

    }

    @Around(value = "pointCut() && @annotation(lock)", argNames = "point,lock")
    public Object lock(ProceedingJoinPoint point, DistributedLock lock) throws Throwable {
        // 获取类名
        String className = point.getTarget().getClass().getSimpleName();
        // 获取方法名
        String methodName = point.getSignature().getName();
        String lockKey = lock.lockKey();
        int waitTime = lock.waitTime();
        int releaseTime = lock.releaseTime();
        boolean isLocked = locker.tryLock(lockKey, waitTime, releaseTime);
        log.info("Run distributed lock, class: {}, method: {}, lockKey: {}, waitTime: {}, releaseTime: {}, lock result: {}",
                className, methodName, lockKey, waitTime, releaseTime, isLocked);
        AssertUtils.isTrue(isLocked, "system.is.busy");
        Object result;
        try {
            result = point.proceed();
        } finally {
            locker.unlock(lockKey);
        }
        return result;
    }

}
