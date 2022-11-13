package com.jy.stock.dao.entity.goods;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@Data
@TableName(value = "goods_unit")
public class GoodsUnit {
    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 计量单位
     */
    private Long unitName;

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