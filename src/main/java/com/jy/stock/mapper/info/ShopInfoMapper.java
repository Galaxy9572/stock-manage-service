package com.jy.stock.mapper.info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.info.ShopInfo;
import com.jy.stock.model.request.info.QueryShopInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface ShopInfoMapper extends BaseMapper<ShopInfo> {

    IPage<ShopInfo> listShopInfoByPage(@Param("page") Page<ShopInfo> pageParam, @Param("param") QueryShopInfoReq param);

    int disableDefaultShopException(Long id);

}