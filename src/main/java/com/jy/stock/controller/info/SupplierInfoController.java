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
import com.jy.stock.pojo.converter.info.SupplierConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.info.SupplierInfoDTO;
import com.jy.stock.pojo.request.info.AddModifySupplierInfoReq;
import com.jy.stock.pojo.request.info.QuerySupplierInfoReq;
import com.jy.stock.pojo.vo.info.SupplierInfoVO;
import com.jy.stock.service.info.SupplierInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 供应商信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/supplier")
public class SupplierInfoController extends EnhancedController<SupplierInfoVO, SupplierInfoDTO> {
    
    @Resource
    private SupplierInfoService supplierInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SUPPLIER, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<SupplierInfoVO> addModifySupplierInfo(@RequestBody @Valid AddModifySupplierInfoReq request){
        SupplierInfoDTO customerInfo = supplierInfoService.addModifySupplierInfo(request);
        SupplierInfoVO customerInfoVO = toVo(customerInfo);
        return ResponseVO.success(customerInfoVO);
    }

    @GetMapping("/{id}/detail")
    public ResponseVO<SupplierInfoVO> getSupplierInfoDetail(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        SupplierInfoDTO customerInfo = supplierInfoService.getSupplierInfoById(id);
        SupplierInfoVO customerInfoVO = toVo(customerInfo);
        return ResponseVO.success(customerInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.SUPPLIER, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteSupplierInfo(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        boolean isSuccess = supplierInfoService.deleteSupplierInfo(id);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<SupplierInfoVO>> listSupplierInfoByPage(@RequestBody @Valid QuerySupplierInfoReq request){
        PageDTO<SupplierInfoDTO> pageDTO = supplierInfoService.listSupplierInfoByPage(request);
        PageVO<SupplierInfoVO> customerInfoPage = toPageVO(pageDTO);
        return ResponseVO.success(customerInfoPage);
    }

    @Override
    protected SupplierInfoVO toVo(SupplierInfoDTO supplierInfoDTO) {
        return SupplierConverter.dtoToVo(supplierInfoDTO);
    }

    @Override
    public Class<SupplierInfoVO> getVoClass() {
        return SupplierInfoVO.class;
    }
}
