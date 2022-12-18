package com.jy.stock.common.util;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author liaojunyao
 */
@Slf4j
@Component
public class DistributedLocker {

    @Resource
    private RedissonClient client;

    /**
     * 加锁
     *
     * @param lockKey lockKey
     * @return RLock
     */
    public RLock lock(String lockKey) {
        RLock lock = client.getLock(lockKey);
        lock.lock();
        log.info("Get lock success, lock key :{}", lockKey);
        return lock;
    }

    /**
     * 带超时的锁
     *
     * @param lockKey lockKey
     * @param timeout 超时时间 单位：秒
     */
    public RLock lock(String lockKey, int timeout) {
        return lock(lockKey, timeout, TimeUnit.SECONDS);
    }

    /**
     * 带超时的锁
     *
     * @param lockKey lockKey
     * @param timeout 超时时间
     * @param unit    时间单位
     */
    public RLock lock(String lockKey, int timeout, TimeUnit unit) {
        RLock lock = client.getLock(lockKey);
        lock.lock(timeout, unit);
        log.info("Get lock success, lock key :{}", lockKey);
        return lock;
    }


    /**
     * 尝试获取锁
     *
     * @param lockKey lockKey
     * @param waitTime  最多等待时间
     * @param releaseTime 上锁后自动释放锁时间
     *                  默认时间单位：秒
     * @return 是否成功
     */
    public boolean tryLock(String lockKey, int waitTime, int releaseTime) {
        return tryLock(lockKey, waitTime, releaseTime, TimeUnit.SECONDS);
    }

    /**
     * 尝试获取锁
     *
     * @param lockKey lockKey
     * @param waitTime  最多等待时间
     * @param releaseTime 上锁后自动释放锁时间
     * @param unit      时间单位
     * @return 是否成功
     */
    public boolean tryLock(String lockKey, int waitTime, int releaseTime, TimeUnit unit) {
        RLock lock = client.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, releaseTime, unit);
        } catch (InterruptedException e) {
            log.info("Release lock failed, lock key: " + lockKey, e);
            return false;
        }
    }

    /**
     * 释放锁
     *
     * @param lockKey lockKey
     */
    public void unlock(String lockKey) {
        RLock lock = client.getLock(lockKey);
        // 释放锁,判断要解锁的key是否已被锁定并且是否被当前线程保持
        if (lock.isLocked() && lock.isHeldByCurrentThread()) {
            lock.unlock();
            log.info("Release lock success, lock key :{}", lockKey);
        }
    }

}
