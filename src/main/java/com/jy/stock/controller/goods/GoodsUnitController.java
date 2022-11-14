package com.jy.stock.controller.goods;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;
import com.jy.stock.pojo.response.goods.GoodsUnitVO;
import com.jy.stock.service.goods.GoodsFacadeService;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/goods/unit")
public class GoodsUnitController extends EnhancedController<GoodsUnitVO, GoodsUnitDTO> {

    @Resource
    private GoodsFacadeService goodsFacadeService;

    @PostMapping("")
    public ResponseVO<GoodsUnitVO> addGoodsUnit(@RequestBody @Valid AddModifyGoodsUnitReq req){
        GoodsUnitDTO goodsUnitDTO = goodsFacadeService.addModifyGoodsUnit(req);
        GoodsUnitVO goodsUnitVO = new GoodsUnitVO();
        BeanCopyUtils.copy(goodsUnitDTO, goodsUnitVO);
        return ResponseVO.success(goodsUnitVO);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<GoodsUnitVO>> listGoodsUnit(@RequestBody @Valid QueryGoodsUnitReq req){
        PageDTO<GoodsUnitDTO> pageDTO = goodsFacadeService.listGoodsUnit(req);
        PageVO<GoodsUnitVO> pageVO = toPageVO(pageDTO);
        return ResponseVO.success(pageVO);
    }

    @Override
    public Class<GoodsUnitVO> getVoClass() {
        return GoodsUnitVO.class;
    }
}
