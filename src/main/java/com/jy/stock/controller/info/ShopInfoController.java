package com.jy.stock.controller.info;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.model.converter.info.ShopInfoConverter;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.ShopInfoDTO;
import com.jy.stock.model.request.info.AddModifyShopInfoReq;
import com.jy.stock.model.request.info.ModifyDefaultShopReq;
import com.jy.stock.model.request.info.QueryShopInfoReq;
import com.jy.stock.model.vo.info.ShopInfoVO;
import com.jy.stock.service.info.ShopInfoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 门店信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/shop")
public class ShopInfoController extends EnhancedController<ShopInfoVO, ShopInfoDTO> {

    @Autowired
    private ShopInfoService shopInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SHOP_INFO, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public HttpResult<ShopInfoVO> addModifyShopInfo(@Valid @RequestBody AddModifyShopInfoReq request) {
        ShopInfoDTO shopInfoDTO = shopInfoService.addModifyShopInfo(request);
        ShopInfoVO shopInfoVO = toVo(shopInfoDTO);
        return HttpResult.success(shopInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SHOP_INFO, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> deleteShopInfo(@PathVariable Long id) {
        boolean isSuccess = shopInfoService.deleteShopInfo(id);
        return HttpResult.success(isSuccess);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SHOP_INFO, operationType = OperationTypeEnum.UPDATE)
    @PutMapping("/default-shop")
    public HttpResult<Boolean> setDefaultShop(@Valid @RequestBody ModifyDefaultShopReq request) {
        boolean isSuccess = shopInfoService.setDefaultShop(request.getId(), request.getDefaultShop());
        return HttpResult.success(isSuccess);
    }

    @PostMapping("/list")
    public HttpResult<PageVO<ShopInfoVO>> listShopInfoByPage(@Valid @RequestBody QueryShopInfoReq request) {
        PageDTO<ShopInfoDTO> page = shopInfoService.listShopInfoByPage(request);
        PageVO<ShopInfoVO> pageVO = toPageVO(page);
        return HttpResult.success(pageVO);
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
