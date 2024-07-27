package com.jy.stock.model.dto;

import com.jy.stock.model.dto.system.UserInfoDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liaojunyao
 */
@Data
public class BaseDTO {

    /**
     * 主键
     */
    protected Long id;

    /**
     * 创建人
     */
    protected UserInfoDTO createUser;

    /**
     * 更新用户
     */
    protected UserInfoDTO updateUser;

    /**
     * 创建时间
     */
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    protected LocalDateTime updateTime;

    /**
     * 逻辑删除
     */
    protected Boolean logicDelete;
    
}
