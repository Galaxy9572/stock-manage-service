package com.jy.stock.controller.info;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.pojo.dto.info.ShopInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyShopInfoReq;
import com.jy.stock.pojo.vo.info.ShopInfoVO;
import com.jy.stock.service.info.ShopInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 门店信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/shop")
public class ShopInfoController extends EnhancedController<ShopInfoVO, ShopInfoDTO> {

    @Resource
    private ShopInfoService shopInfoService;

    @PostMapping("")
    public ResponseVO<ShopInfoVO> addModifyShopInfoService(@Valid @RequestBody AddModifyShopInfoReq request) {

        return null;
    }

    @Override
    public Class<ShopInfoVO> getVoClass() {
        return ShopInfoVO.class;
    }
}
