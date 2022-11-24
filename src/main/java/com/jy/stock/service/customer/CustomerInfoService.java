package com.jy.stock.service.customer;

import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.request.customer.AddModifyCustomerInfoReq;
import com.jy.stock.pojo.request.customer.QueryCustomerInfoReq;

public interface CustomerInfoService extends IService<CustomerInfo>{


    CustomerInfoDTO addModifyCustomerInfo(AddModifyCustomerInfoReq request);

    boolean deleteCustomerInfo(Long id);

    PageDTO<CustomerInfoDTO> listCustomerInfoByPage(QueryCustomerInfoReq request);

    CustomerInfoDTO getCustomerInfoById(Long id);

    CustomerInfoDTO getCustomerInfoByName(String customerName);
}
