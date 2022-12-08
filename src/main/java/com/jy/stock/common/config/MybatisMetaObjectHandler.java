package com.jy.stock.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jy.stock.common.util.ContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 数据自动填充配置
 * @author liaojunyao
 */
@Slf4j
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = ContextHolder.currentUserId();
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createUserId", Long.class, userId);
        this.strictInsertFill(metaObject, "updateUserId", Long.class, userId);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Long userId = ContextHolder.currentUserId();
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateUserId", Long.class, userId);
    }

}
