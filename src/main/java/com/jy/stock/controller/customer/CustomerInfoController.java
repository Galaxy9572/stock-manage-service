package com.jy.stock.controller.customer;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.request.customer.AddModifyCustomerInfoReq;
import com.jy.stock.pojo.response.customer.CustomerInfoVO;
import com.jy.stock.service.customer.CustomerInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 客户信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/customer-info")
public class CustomerInfoController extends EnhancedController<CustomerInfoVO, CustomerInfoDTO> {

    @Resource
    private CustomerInfoService customerInfoService;

    @PostMapping("")
    public ResponseVO<CustomerInfoVO> addModifyCustomerInfo(@RequestBody @Valid AddModifyCustomerInfoReq request){

    }


    @Override
    public Class<CustomerInfoVO> getVoClass() {
        return CustomerInfoVO.class;
    }
}
