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
import com.jy.stock.model.converter.info.CustomerConverter;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.CustomerInfoDTO;
import com.jy.stock.model.request.info.AddModifyCustomerInfoReq;
import com.jy.stock.model.request.info.QueryCustomerInfoReq;
import com.jy.stock.model.vo.info.CustomerInfoVO;
import com.jy.stock.service.info.CustomerInfoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 客户信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/info/customer")
public class CustomerInfoController extends EnhancedController<CustomerInfoVO, CustomerInfoDTO> {

    @Autowired
    private CustomerInfoService customerInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.CUSTOMER, operationType = OperationTypeEnum.ADD_MODIFY)
    @PostMapping("")
    public HttpResult<CustomerInfoVO> addModifyCustomerInfo(@RequestBody @Valid AddModifyCustomerInfoReq request){
        CustomerInfoDTO customerInfo = customerInfoService.addModifyCustomerInfo(request);
        CustomerInfoVO customerInfoVO = toVo(customerInfo);
        return HttpResult.success(customerInfoVO);
    }

    @GetMapping("/{id}/detail")
    public HttpResult<CustomerInfoVO> getCustomerInfoDetail(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        CustomerInfoDTO customerInfo = customerInfoService.getCustomerInfoById(id);
        CustomerInfoVO customerInfoVO = toVo(customerInfo);
        return HttpResult.success(customerInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.INFO, subModule = SubModuleEnum.CUSTOMER, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public HttpResult<Boolean> deleteCustomerInfo(@PathVariable @Valid @Min(value = 1, message = "param.invalid") Long id){
        boolean isSuccess = customerInfoService.deleteCustomerInfo(id);
        return HttpResult.success(isSuccess);
    }

    @PostMapping("/list")
    public HttpResult<PageVO<CustomerInfoVO>> listCustomerInfoByPage(@RequestBody @Valid QueryCustomerInfoReq request){
        PageDTO<CustomerInfoDTO> pageDTO = customerInfoService.listCustomerInfoByPage(request);
        PageVO<CustomerInfoVO> customerInfoPage = toPageVO(pageDTO);
        return HttpResult.success(customerInfoPage);
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
