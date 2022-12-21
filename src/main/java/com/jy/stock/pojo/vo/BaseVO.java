package com.jy.stock.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.stock.pojo.vo.system.UserInfoVO;
import lombok.Data;

import java.util.Date;

/**
 * @author liaojunyao
 */
@Data
public class BaseVO {

    /**
     * 主键，Java中Long可以表示的最大值是2^63-1，JS的Number可以表示的最大值是2^53。
     * 后端返回的数据大于Number能表示的最大值时无法正确解析，出现精度丢失的问题
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新时间
     */
    protected Date updateTime;

    /**
     * 创建人
     */
    protected UserInfoVO createUser;

    /**
     * 更新人
     */
    protected UserInfoVO updateUser;

}
