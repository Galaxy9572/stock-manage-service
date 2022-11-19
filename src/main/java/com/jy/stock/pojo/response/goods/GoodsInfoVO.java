package com.jy.stock.pojo.response.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 商品
 * @author liaojunyao
 */
@Data
public class GoodsInfoVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 品名
     */
    private String goodsName;

    /**
     * 商品类别ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long goodsTypeId;

    /**
     * 商品计量单位ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long goodsUnitId;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建人ID
     */
    private Long createUserId;

    /**
     * 更新用户ID
     */
    private Long updateUserId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}