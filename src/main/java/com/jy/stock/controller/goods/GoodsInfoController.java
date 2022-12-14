package com.jy.stock.controller.goods;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.pojo.converter.goods.GoodsConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsInfoReq;
import com.jy.stock.pojo.request.goods.QueryGoodsInfoReq;
import com.jy.stock.pojo.vo.goods.GoodsInfoVO;
import com.jy.stock.service.goods.GoodsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 商品单位控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/info")
public class GoodsInfoController extends EnhancedController<GoodsInfoVO, GoodsInfoDTO> {

    @Resource
    private GoodsInfoService goodsInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_INFO, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<GoodsInfoVO> addModifyGoodsInfo(@RequestBody @Valid AddModifyGoodsInfoReq req){
        GoodsInfoDTO goodsInfoDTO = goodsInfoService.addModifyGoodsInfo(req);
        GoodsInfoVO goodsInfoVO = new GoodsInfoVO();
        BeanCopyUtils.copy(goodsInfoDTO, goodsInfoVO);
        return ResponseVO.success(goodsInfoVO);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<GoodsInfoVO>> listGoodsInfo(@RequestBody @Valid QueryGoodsInfoReq req){
        PageDTO<GoodsInfoDTO> pageDTO = goodsInfoService.listGoodsInfo(req);
        PageVO<GoodsInfoVO> pageVO = toPageVO(pageDTO);
        return ResponseVO.success(pageVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_INFO, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteGoodsInfo(@PathVariable Long id){
        boolean isSuccess = goodsInfoService.deleteGoodsInfo(id);
        return ResponseVO.success(isSuccess);
    }

    @GetMapping("/{id}/detail")
    public ResponseVO<GoodsInfoVO> getGoodsInfoDetail(@PathVariable Long id){
        GoodsInfoDTO goodsInfoDTO = goodsInfoService.getGoodsInfoDetail(id);
        GoodsInfoVO goodsInfoVO = toVo(goodsInfoDTO);
        return ResponseVO.success(goodsInfoVO);
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
