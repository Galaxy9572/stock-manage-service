package com.jy.stock.pojo.response.goods;

import lombok.Data;

import java.util.Date;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@Data
public class GoodsUnitVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    private Boolean logicDelete;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 更新人ID
     */
    private Long updateUserId;
}