package com.jy.stock.dao.entity.goods;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
@Document(collection = "goods_type")
public class GoodsType {
    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 商品类别名称
     */
    private String typeName;

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
     * 创建用户ID
     */
    private Long createUserId;

    /**
     * 更新用户ID
     */
    private Long updateUserId;

    /**
     * 孩子节点
     */
    private List<GoodsType> children;
}