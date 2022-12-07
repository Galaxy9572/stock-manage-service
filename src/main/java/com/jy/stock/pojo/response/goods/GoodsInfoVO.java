package com.jy.stock.pojo.response.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.stock.pojo.response.user.UserInfoVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * @author liaojunyao
 */
@Data
public class GoodsInfoVO {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 品名
     */
    private String goodsName;

    /**
     * 商品类别
     */
    private GoodsTypeVO goodsType;

    /**
     * 商品计量单位
     */
    private GoodsUnitVO goodsUnit;

    /**
     * 进货价
     */
    private BigDecimal purchasePrice;

    /**
     * 零售价
     */
    private BigDecimal retailPrice;

    /**
     * 批发价
     */
    private BigDecimal wholesalePrice;

    /**
     * 备注
     */
    private String memo;

    /**
     * 创建人
     */
    private UserInfoVO createUser;

    /**
     * 更新用户
     */
    private UserInfoVO updateUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}