package com.jy.stock.controller.info;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.pojo.converter.info.ShopInfoConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.ShopInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyShopInfoReq;
import com.jy.stock.pojo.request.info.QueryShopInfoReq;
import com.jy.stock.pojo.vo.info.ShopInfoVO;
import com.jy.stock.service.info.ShopInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 门店信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/shop")
public class ShopInfoController extends EnhancedController<ShopInfoVO, ShopInfoDTO> {

    @Resource
    private ShopInfoService shopInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SHOP_INFO, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<ShopInfoVO> addModifyShopInfoService(@Valid @RequestBody AddModifyShopInfoReq request) {
        ShopInfoDTO shopInfoDTO = shopInfoService.addModifyShopInfo(request);
        ShopInfoVO shopInfoVO = toVo(shopInfoDTO);
        return ResponseVO.success(shopInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SHOP_INFO, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteShopInfo(@PathVariable Long id) {
        boolean isSuccess = shopInfoService.deleteShopInfo(id);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<ShopInfoVO>> listShopInfoByPage(@Valid @RequestBody QueryShopInfoReq request) {
        PageDTO<ShopInfoDTO> page = shopInfoService.listShopInfoByPage(request);
        PageVO<ShopInfoVO> pageVO = toPageVO(page);
        return ResponseVO.success(pageVO);
    }

    @Override
    protected ShopInfoVO toVo(ShopInfoDTO dto) {
        return ShopInfoConverter.dtoToVo(dto);
    }

    @Override
    public Class<ShopInfoVO> getVoClass() {
        return ShopInfoVO.class;
    }
}
