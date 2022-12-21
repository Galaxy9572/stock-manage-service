package com.jy.stock.pojo.vo.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 操作记录表
 * @author liaojunyao
 */
@Data
public class OperationLogVO {
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 操作人
     */
    private UserInfoVO operateUser;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING)
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