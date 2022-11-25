package com.jy.stock.controller.goods;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.pojo.response.goods.GoodsTypeVO;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品类型控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/type")
public class GoodsTypeController extends EnhancedController<GoodsTypeVO, GoodsTypeDTO> {

    @Resource
    private GoodsTypeService goodsTypeService;

    @PostMapping("")
    public ResponseVO<Void> addModifyGoodsType(@RequestBody AddModifyGoodsTypeReq request) {
        goodsTypeService.addModifyGoodsType(request);
        return ResponseVO.success();
    }

    @Override
    public Class<GoodsTypeVO> getVoClass() {
        return GoodsTypeVO.class;
    }
}
