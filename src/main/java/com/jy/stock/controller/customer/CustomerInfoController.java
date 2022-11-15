package com.jy.stock.controller.customer;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.response.customer.CustomerInfoVO;
import com.jy.stock.service.customer.CustomerInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/customer-info")
public class CustomerInfoController extends EnhancedController<CustomerInfoVO, CustomerInfoDTO> {

    @Resource
    private CustomerInfoService customerInfoServiceImpl;


    @Override
    public Class<CustomerInfoVO> getVoClass() {
        return CustomerInfoVO.class;
    }
}
