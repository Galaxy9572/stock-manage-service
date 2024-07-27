package com.jy.stock.model.dto.system;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作记录表
 * @author liaojunyao
 */
@Data
public class OperationLogDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 操作人
     */
    private UserInfoDTO operateUser;

    /**
     * 模块
     */
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
    private LocalDateTime createTime;
}