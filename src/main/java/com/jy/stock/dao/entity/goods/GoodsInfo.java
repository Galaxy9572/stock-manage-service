package com.jy.stock.dao.entity.goods;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 商品
 * @author liaojunyao
 */
@Data
@TableName(value = "goods_info")
public class GoodsInfo {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 品名
     */
    private String goodsName;

    /**
     * 商品类别ID
     */
    private Long goodsTypeId;

    /**
     * 商品计量单位ID
     */
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

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean logicDelete;
}