package com.jy.stock.pojo.dto;

import com.jy.stock.pojo.dto.system.UserInfoDTO;
import lombok.Data;

import java.util.Date;

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
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 逻辑删除
     */
    protected Boolean logicDelete;
    
}
