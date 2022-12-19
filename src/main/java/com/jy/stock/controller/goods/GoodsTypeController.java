package com.jy.stock.controller.goods;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.pojo.converter.goods.GoodsConverter;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.pojo.response.goods.GoodsTypeVO;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品类型控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/type")
public class GoodsTypeController extends EnhancedController<GoodsTypeVO, GoodsTypeDTO> {

    @Resource
    private GoodsTypeService goodsTypeService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_TYPE, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<GoodsTypeVO> addModifyGoodsType(@RequestBody AddModifyGoodsTypeReq request) {
        GoodsTypeDTO goodsTypeDTO = goodsTypeService.addModifyGoodsType(request);
        return ResponseVO.success(toVo(goodsTypeDTO));
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.GOODS, subModule = SubModuleEnum.GOODS_TYPE, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteGoodsType(@PathVariable Long id) {
        Boolean isSuccess = goodsTypeService.deleteGoodsType(id);
        return ResponseVO.success(isSuccess);
    }

    @GetMapping("/list")
    public ResponseVO<List<GoodsTypeVO>> listAllGoodsTypes(@RequestParam(required = false) Long parentTypeId) {
        List<GoodsTypeDTO> dtoList = goodsTypeService.listAllGoodsTypes(parentTypeId);
        List<GoodsTypeVO> voList = GoodsConverter.dtoListToVoList(dtoList);
        return ResponseVO.success(voList);
    }

    @Override
    public Class<GoodsTypeVO> getVoClass() {
        return GoodsTypeVO.class;
    }
}
