package com.jy.stock.service.customer;

import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;

public interface CustomerInfoService extends IService<CustomerInfo>{


    CustomerInfoDTO getCustomerInfoByName(String customerName);
}
