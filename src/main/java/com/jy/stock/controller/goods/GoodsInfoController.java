package com.jy.stock.controller.goods;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.model.converter.goods.GoodsConverter;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.goods.GoodsInfoDTO;
import com.jy.stock.model.request.goods.AddModifyGoodsInfoReq;
import com.jy.stock.model.request.goods.QueryGoodsInfoReq;
import com.jy.stock.model.vo.goods.GoodsInfoVO;
import com.jy.stock.service.goods.GoodsInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品单位控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/info")
public class GoodsInfoController extends EnhancedController<GoodsInfoVO, GoodsInfoDTO> {

    @Autowired
    private GoodsInfoService goodsInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_INFO, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public HttpResult<GoodsInfoVO> addModifyGoodsInfo(@RequestBody @Valid AddModifyGoodsInfoReq req){
        GoodsInfoDTO goodsInfoDTO = goodsInfoService.addModifyGoodsInfo(req);
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        BeanCopyUtils.copy(goodsInfoDTO, goodsInfoVO);
        return HttpResult.success(goodsInfoVO);
    }

    @PostMapping("/list")
    public HttpResult<PageVO<GoodsInfoVO>> listGoodsInfo(@RequestBody @Valid QueryGoodsInfoReq req){
        PageDTO<GoodsInfoDTO> pageDTO = goodsInfoService.listGoodsInfo(req);
        PageVO<GoodsInfoVO> pageVO = toPageVO(pageDTO);
        return HttpResult.success(pageVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_INFO, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> deleteGoodsInfo(@PathVariable Long id){
        boolean isSuccess = goodsInfoService.deleteGoodsInfo(id);
        return HttpResult.success(isSuccess);
    }

    @GetMapping("/{id}/detail")
    public HttpResult<GoodsInfoVO> getGoodsInfoDetail(@PathVariable Long id){
        GoodsInfoDTO goodsInfoDTO = goodsInfoService.getGoodsInfoDetail(id);
        GoodsInfoVO goodsInfoVO = toVo(goodsInfoDTO);
        return HttpResult.success(goodsInfoVO);
    }

    @Override
    protected GoodsInfoVO toVo(GoodsInfoDTO goodsInfoDTO) {
        return GoodsConverter.dtoToVo(goodsInfoDTO);
    }

    @Override
    public Class<GoodsInfoVO> getVoClass() {
        return GoodsInfoVO.class;
    }
}
