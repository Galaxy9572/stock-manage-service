package com.jy.stock.controller.goods;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.dto.goods.GoodsStockDTO;
import com.jy.stock.pojo.request.goods.ModifyGoodsStockWarningReq;
import com.jy.stock.pojo.response.goods.GoodsStockVO;
import com.jy.stock.service.goods.GoodsStockService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 商品单位控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/stock")
public class GoodsStockController extends EnhancedController<GoodsStockVO, GoodsStockDTO> {

    @Resource
    private GoodsStockService goodsInfoService;

    @PutMapping("/warning")
    public ResponseVO<GoodsStockVO> modifyGoodsStockWarning(@RequestBody @Valid ModifyGoodsStockWarningReq req){
        GoodsStockDTO goodsInfoDTO = goodsInfoService.modifyGoodsStockWarning(req);
        GoodsStockVO goodsInfoVO = new GoodsStockVO();
        BeanCopyUtils.copy(goodsInfoDTO, goodsInfoVO);
        return ResponseVO.success(goodsInfoVO);
    }

    @Override
    public Class<GoodsStockVO> getVoClass() {
        return GoodsStockVO.class;
    }
}
