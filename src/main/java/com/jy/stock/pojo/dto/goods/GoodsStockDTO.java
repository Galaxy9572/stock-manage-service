package com.jy.stock.pojo.dto.goods;

import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import lombok.Data;

import java.util.Date;

/**
 * 商品库存
 * @author liaojunyao
 */
@Data
public class GoodsStockDTO {
    /**
     * 商品库存ID
     */
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
     * 当前库存数量
     */
    private Long currentStockNum;

    /**
     * 是否允许库存告警
     */
    private Boolean allowStockWarning;

    /**
     * 创建用户
     */
    private UserInfoDTO createUser;

    /**
     * 更新用户
     */
    private UserInfoDTO updateUser;

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
}