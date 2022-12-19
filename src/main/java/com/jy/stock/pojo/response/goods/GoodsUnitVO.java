package com.jy.stock.pojo.response.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.stock.pojo.response.system.UserInfoVO;
import lombok.Data;

import java.util.Date;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@Data
public class GoodsUnitVO {
    /**
     * 主键，Java中Long可以表示的最大值是2^63-1，JS的Number可以表示的最大值是2^53。
     * 后端返回的数据大于Number能表示的最大值时无法正确解析，出现精度丢失的问题
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 是否允许小数
     */
    private Boolean allowDecimal;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private UserInfoVO createUser;

    /**
     * 更新人
     */
    private UserInfoVO updateUser;
}