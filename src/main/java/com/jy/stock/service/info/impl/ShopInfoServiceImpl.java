package com.jy.stock.service.info.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.info.ShopInfo;
import com.jy.stock.dao.mapper.info.ShopInfoMapper;
import com.jy.stock.pojo.dto.info.ShopInfoDTO;
import com.jy.stock.service.info.ShopInfoService;
import org.springframework.stereotype.Service;
/**
 * @author liaojunyao
 */
@Service
public class ShopInfoServiceImpl extends EnhancedServiceImpl<ShopInfoMapper, ShopInfo, ShopInfoDTO> implements ShopInfoService{

    @Override
    public Class<ShopInfoDTO> getDtoClass() {
        return ShopInfoDTO.class;
    }

}
