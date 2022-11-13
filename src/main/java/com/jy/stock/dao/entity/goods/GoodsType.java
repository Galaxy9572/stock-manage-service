package com.jy.stock.dao.entity.goods;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
@TableName(value = "goods_type")
public class GoodsType {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 逻辑删除
     */
    @TableLogic
    private Boolean logicDelete;

    /**
     * 创建用户ID
     */
    private Long createUserId;

    /**
     * 更新用户ID
     */
    private Long updateUserId;
}