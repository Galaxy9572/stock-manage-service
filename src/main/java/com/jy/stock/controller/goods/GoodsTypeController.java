package com.jy.stock.controller.goods;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.model.converter.goods.GoodsConverter;
import com.jy.stock.model.dto.goods.GoodsTypeDTO;
import com.jy.stock.model.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.model.vo.goods.GoodsTypeVO;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品类型控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/type")
public class GoodsTypeController extends EnhancedController<GoodsTypeVO, GoodsTypeDTO> {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_TYPE, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public HttpResult<GoodsTypeVO> addModifyGoodsType(@RequestBody AddModifyGoodsTypeReq request) {
        GoodsTypeDTO goodsTypeDTO = goodsTypeService.addModifyGoodsType(request);
        return HttpResult.success(toVo(goodsTypeDTO));
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_TYPE, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> deleteGoodsType(@PathVariable Long id) {
        Boolean isSuccess = goodsTypeService.deleteGoodsType(id);
        return HttpResult.success(isSuccess);
    }

    @GetMapping("/list")
    public HttpResult<List<GoodsTypeVO>> listAllGoodsTypes(@RequestParam(required = false) Long parentTypeId) {
        List<GoodsTypeDTO> dtoList = goodsTypeService.listAllGoodsTypes(parentTypeId);
        List<GoodsTypeVO> voList = GoodsConverter.dtoListToVoList(dtoList);
        return HttpResult.success(voList);
    }

    @Override
    public Class<GoodsTypeVO> getVoClass() {
        return GoodsTypeVO.class;
    }
}
