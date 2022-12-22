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
import com.jy.stock.pojo.converter.info.WarehouseInfoConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.WarehouseInfoDTO;
import com.jy.stock.pojo.request.info.AddModifyWarehouseInfoReq;
import com.jy.stock.pojo.request.info.QueryWarehouseInfoReq;
import com.jy.stock.pojo.vo.info.WarehouseInfoVO;
import com.jy.stock.service.info.WarehouseInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 仓库信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/warehouse")
public class WarehouseInfoController extends EnhancedController<WarehouseInfoVO, WarehouseInfoDTO> {

    @Resource
    private WarehouseInfoService warehouseInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.WAREHOUSE_INFO, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<WarehouseInfoVO> addModifyWarehouseInfo(@Valid @RequestBody AddModifyWarehouseInfoReq request) {
        WarehouseInfoDTO warehouseInfoDTO = warehouseInfoService.addModifyWarehouseInfo(request);
        WarehouseInfoVO warehouseInfoVO = toVo(warehouseInfoDTO);
        return ResponseVO.success(warehouseInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.WAREHOUSE_INFO, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteWarehouseInfo(@PathVariable Long id) {
        boolean isSuccess = warehouseInfoService.deleteWarehouseInfo(id);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<WarehouseInfoVO>> listWarehouseInfoByPage(@Valid @RequestBody QueryWarehouseInfoReq request) {
        PageDTO<WarehouseInfoDTO> page = warehouseInfoService.listWarehouseInfoByPage(request);
        PageVO<WarehouseInfoVO> pageVO = toPageVO(page);
        return ResponseVO.success(pageVO);
    }

    @Override
    protected WarehouseInfoVO toVo(WarehouseInfoDTO dto) {
        return WarehouseInfoConverter.dtoToVo(dto);
    }

    @Override
    public Class<WarehouseInfoVO> getVoClass() {
        return WarehouseInfoVO.class;
    }
}
