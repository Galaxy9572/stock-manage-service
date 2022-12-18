package com.jy.stock.controller.customer;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.enums.system.operation.ModuleEnum;
import com.jy.stock.enums.system.operation.OperationTypeEnum;
import com.jy.stock.enums.system.operation.SubModuleEnum;
import com.jy.stock.enums.system.user.UserRoleEnum;
import com.jy.stock.pojo.converter.customer.CustomerConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.request.customer.AddModifyCustomerInfoReq;
import com.jy.stock.pojo.request.customer.QueryCustomerInfoReq;
import com.jy.stock.pojo.response.customer.CustomerInfoVO;
import com.jy.stock.service.customer.CustomerInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * 客户信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/customer/info")
public class CustomerInfoController extends EnhancedController<CustomerInfoVO, CustomerInfoDTO> {

    @Resource
    private CustomerInfoService customerInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.CUSTOMER, subModule = SubModuleEnum.CUSTOMER, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public ResponseVO<CustomerInfoVO> addModifyCustomerInfo(@RequestBody @Valid AddModifyCustomerInfoReq request){
        CustomerInfoDTO customerInfo = customerInfoService.addModifyCustomerInfo(request);
        CustomerInfoVO customerInfoVO = toVo(customerInfo);
        return ResponseVO.success(customerInfoVO);
    }

    @GetMapping("/{id}/detail")
    public ResponseVO<CustomerInfoVO> getCustomerInfoDetail(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        CustomerInfoDTO customerInfo = customerInfoService.getCustomerInfoById(id);
        CustomerInfoVO customerInfoVO = toVo(customerInfo);
        return ResponseVO.success(customerInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.CUSTOMER, subModule = SubModuleEnum.CUSTOMER, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteCustomerInfo(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        boolean isSuccess = customerInfoService.deleteCustomerInfo(id);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<CustomerInfoVO>> listCustomerInfoByPage(@RequestBody @Valid QueryCustomerInfoReq request){
        PageDTO<CustomerInfoDTO> pageDTO = customerInfoService.listCustomerInfoByPage(request);
        PageVO<CustomerInfoVO> customerInfoPage = toPageVO(pageDTO);
        return ResponseVO.success(customerInfoPage);
    }

    @Override
    protected CustomerInfoVO toVo(CustomerInfoDTO customerInfoDTO) {
        return CustomerConverter.dtoToVo(customerInfoDTO);
    }

    @Override
    public Class<CustomerInfoVO> getVoClass() {
        return CustomerInfoVO.class;
    }
}
