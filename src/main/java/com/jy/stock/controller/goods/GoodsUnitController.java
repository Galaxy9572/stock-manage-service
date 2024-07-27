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
import com.jy.stock.model.converter.system.UserConverter;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.goods.GoodsUnitDTO;
import com.jy.stock.model.request.goods.AddModifyGoodsUnitReq;
import com.jy.stock.model.request.goods.QueryGoodsUnitReq;
import com.jy.stock.model.vo.goods.GoodsUnitVO;
import com.jy.stock.service.goods.GoodsUnitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 商品单位控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/unit")
public class GoodsUnitController extends EnhancedController<GoodsUnitVO, GoodsUnitDTO> {

    @Autowired
    private GoodsUnitService goodsUnitService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_UNIT, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public HttpResult<GoodsUnitVO> addModifyGoodsUnit(@RequestBody @Valid AddModifyGoodsUnitReq req){
        GoodsUnitDTO goodsUnitDTO = goodsUnitService.addModifyGoodsUnit(req);
        GoodsUnitVO goodsUnitVO = new GoodsUnitVO();
        BeanCopyUtils.copy(goodsUnitDTO, goodsUnitVO);
        return HttpResult.success(goodsUnitVO);
    }

    @PostMapping("/list")
    public HttpResult<PageVO<GoodsUnitVO>> listGoodsUnit(@RequestBody @Valid QueryGoodsUnitReq req){
        PageDTO<GoodsUnitDTO> pageDTO = goodsUnitService.listGoodsUnit(req);
        PageVO<GoodsUnitVO> pageVO = toPageVO(pageDTO);
        return HttpResult.success(pageVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_UNIT, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> deleteGoodsUnit(@PathVariable Long id){
        boolean isSuccess = goodsUnitService.deleteGoodsUnit(id);
        return HttpResult.success(isSuccess);
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
