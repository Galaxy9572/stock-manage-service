package com.jy.stock.pojo.dto.goods;

import com.jy.stock.pojo.dto.user.UserInfoDTO;
import lombok.Data;

import java.util.Date;

/**
 * 商品计量单位
 * @author liaojunyao
 */
@Data
public class GoodsUnitDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 计量单位
     */
    private String unitName;

    /**
     * 是否允许小数
     */
    private Boolean allowDecimal;

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
     * 创建人
     */
    private UserInfoDTO createUser;

    /**
     * 更新人
     */
    private UserInfoDTO updateUser;
}