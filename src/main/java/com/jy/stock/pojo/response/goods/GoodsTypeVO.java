package com.jy.stock.pojo.response.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
public class GoodsTypeVO {
    /**
     * 主键
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 商品类别名称
     */
    private String typeName;

    /**
     * 父类别ID
     */
    private Long parentTypeId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


    /**
     * 创建用户ID
     */
    private Long createUserId;

    /**
     * 更新用户ID
     */
    private Long updateUserId;
}