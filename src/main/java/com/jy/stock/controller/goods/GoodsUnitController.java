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
import com.jy.stock.pojo.converter.system.user.UserConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.pojo.request.goods.QueryGoodsUnitReq;
import com.jy.stock.pojo.vo.goods.GoodsUnitVO;
import com.jy.stock.service.goods.GoodsUnitService;
import org.springframework.web.bind.annotation.*;

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
    private GoodsUnitService goodsUnitService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_UNIT, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<GoodsUnitVO> addModifyGoodsUnit(@RequestBody @Valid AddModifyGoodsUnitReq req){
        GoodsUnitDTO goodsUnitDTO = goodsUnitService.addModifyGoodsUnit(req);
        GoodsUnitVO goodsUnitVO = new GoodsUnitVO();
        BeanCopyUtils.copy(goodsUnitDTO, goodsUnitVO);
        return ResponseVO.success(goodsUnitVO);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<GoodsUnitVO>> listGoodsUnit(@RequestBody @Valid QueryGoodsUnitReq req){
        PageDTO<GoodsUnitDTO> pageDTO = goodsUnitService.listGoodsUnit(req);
        PageVO<GoodsUnitVO> pageVO = toPageVO(pageDTO);
        return ResponseVO.success(pageVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_UNIT, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteGoodsUnit(@PathVariable Long id){
        boolean isSuccess = goodsUnitService.deleteGoodsUnit(id);
        return ResponseVO.success(isSuccess);
    }

    @Override
    protected GoodsUnitVO toVo(GoodsUnitDTO goodsUnitDTO) {
        GoodsUnitVO goodsUnitVO = super.toVo(goodsUnitDTO);
        goodsUnitVO.setCreateUser(UserConverter.dtoToVo(goodsUnitDTO.getCreateUser()));
        goodsUnitVO.setUpdateUser(UserConverter.dtoToVo(goodsUnitDTO.getUpdateUser()));
        return goodsUnitVO;
    }

    @Override
    public Class<GoodsUnitVO> getVoClass() {
        return GoodsUnitVO.class;
    }
}
