package com.jy.stock.pojo.request.goods;

import lombok.Data;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
public class AddModifyGoodsTypeReq {
    /**
     * 主键
     */
    private Long id;

    /**
     * 父节点ID
     */
    private Long parentId;

    /**
     * 商品类别名称
     */
    private String typeName;

}