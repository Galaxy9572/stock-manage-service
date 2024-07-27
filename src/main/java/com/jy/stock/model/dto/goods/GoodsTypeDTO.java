package com.jy.stock.model.dto.goods;

import com.jy.stock.model.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品类别
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsTypeDTO extends BaseDTO {

    /**
     * 商品类别名称
     */
    private String typeName;

    /**
     * 父类别ID
     */
    private Long parentTypeId;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 完整路径
     */
    private String path;

    /**
     * 孩子节点
     */
    private List<GoodsTypeDTO> children;

}