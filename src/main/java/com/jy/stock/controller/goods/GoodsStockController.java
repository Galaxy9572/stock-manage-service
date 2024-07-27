package com.jy.stock.controller.goods;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.dto.goods.GoodsStockDTO;
import com.jy.stock.model.request.goods.ModifyGoodsStockWarningReq;
import com.jy.stock.model.vo.goods.GoodsStockVO;
import com.jy.stock.service.goods.GoodsStockService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品单位控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/stock")
public class GoodsStockController extends EnhancedController<GoodsStockVO, GoodsStockDTO> {

    @Autowired
    private GoodsStockService goodsInfoService;

    @PutMapping("/warning")
    public HttpResult<GoodsStockVO> modifyGoodsStockWarning(@RequestBody @Valid ModifyGoodsStockWarningReq req){
        GoodsStockDTO goodsInfoDTO = goodsInfoService.modifyGoodsStockWarning(req);
        GoodsStockVO goodsInfoVO = new GoodsStockVO();
        BeanCopyUtils.copy(goodsInfoDTO, goodsInfoVO);
        return HttpResult.success(goodsInfoVO);
    }

    @Override
    public Class<GoodsStockVO> getVoClass() {
        return GoodsStockVO.class;
    }
}
