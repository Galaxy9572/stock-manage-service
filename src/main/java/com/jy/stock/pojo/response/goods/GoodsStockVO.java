package com.jy.stock.pojo.response.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.stock.pojo.response.system.user.UserInfoVO;
import lombok.Data;

import java.util.Date;

/**
 * 商品库存
 * @author liaojunyao
 */
@Data
public class GoodsStockVO {
    /**
     * 商品库存ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 初始库存数量
     */
    private Long initStockNum;

    /**
     * 最低库存数量
     */
    private Long minStockNum;

    /**
     * 最高库存数量
     */
    private Long maxStockNum;

    /**
     * 是否允许库存告警
     */
    private Boolean allowStockWarning;

    /**
     * 当前库存数量
     */
    private Long currentStockNum;

    /**
     * 创建用户
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