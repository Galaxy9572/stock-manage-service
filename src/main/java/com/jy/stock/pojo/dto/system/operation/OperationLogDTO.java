package com.jy.stock.pojo.dto.system.operation;

import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import lombok.Data;

import java.util.Date;

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
    private Date createTime;
}