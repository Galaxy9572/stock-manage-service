package com.jy.stock.model.request.goods;

import com.jy.stock.model.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品类别
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddModifyGoodsTypeReq extends AddModifyRequest {

    /**
     * 父节点ID
     */
    private Long parentTypeId;

    /**
     * 商品类别名称
     */
    private String typeName;

}