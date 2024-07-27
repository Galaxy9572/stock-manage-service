package com.jy.stock.model.vo.goods;

import com.jy.stock.model.vo.BaseVO;
import lombok.Data;

import java.util.List;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
public class GoodsTypeVO extends BaseVO {

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
    private List<GoodsTypeVO> children;

}