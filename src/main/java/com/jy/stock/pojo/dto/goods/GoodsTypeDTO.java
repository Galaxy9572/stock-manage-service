package com.jy.stock.pojo.dto.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.stock.pojo.dto.system.UserInfoDTO;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 商品类别
 * @author liaojunyao
 */
@Data
public class GoodsTypeDTO {
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
     * 层级
     */
    private Integer level;

    /**
     * 完整路径
     */
    private String path;

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
     * 创建用户
     */
    private UserInfoDTO createUser;

    /**
     * 更新用户
     */
    private UserInfoDTO updateUser;

    /**
     * 孩子节点
     */
    private List<GoodsTypeDTO> children;

}