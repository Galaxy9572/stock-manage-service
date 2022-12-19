package com.jy.stock.dao.entity.system;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 操作记录表
 * @author liaojunyao
 */
@Data
@TableName(value = "operation_log")
public class OperationLog {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 模块
     */
    @TableField(value = "\"module\"")
    private String module;

    /**
     * 子模块
     */
    private String subModule;

    /**
     * 模块业务主键
     */
    private Long moduleBusinessId;

    /**
     * 操作类型
     */
    private String operationType;

    /**
     * 描述
     */
    private String operationDesc;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}