package com.jy.stock.service.info;

import com.jy.stock.model.entity.info.CustomerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.info.CustomerInfoDTO;
import com.jy.stock.model.request.info.AddModifyCustomerInfoReq;
import com.jy.stock.model.request.info.QueryCustomerInfoReq;

public interface CustomerInfoService extends IService<CustomerInfo>{


    CustomerInfoDTO addModifyCustomerInfo(AddModifyCustomerInfoReq request);

    boolean deleteCustomerInfo(Long id);

    PageDTO<CustomerInfoDTO> listCustomerInfoByPage(QueryCustomerInfoReq request);

    CustomerInfoDTO getCustomerInfoById(Long id);

    CustomerInfoDTO getCustomerInfoByName(String customerName);
}
