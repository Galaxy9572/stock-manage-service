package com.jy.stock.service.info;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.info.ShopInfo;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.ShopInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyShopInfoReq;
import com.jy.stock.pojo.request.info.QueryShopInfoReq;
import org.springframework.transaction.annotation.Transactional;

public interface ShopInfoService extends IService<ShopInfo>{

    ShopInfoDTO addModifyShopInfo(AddModifyShopInfoReq request);

    @Transactional(rollbackFor = Exception.class)
    boolean setDefaultShop(Long id, boolean isDefault);

    boolean deleteShopInfo(Long id);

    ShopInfoDTO getShopInfoDetail(Long id);

    PageDTO<ShopInfoDTO> listShopInfoByPage(QueryShopInfoReq request);

    ShopInfoDTO checkExistenceByName(String shopName, boolean assertExists);
}
