package com.jy.stock.service.customer.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.jy.stock.dao.mapper.customer.CustomerInfoMapper;
import com.jy.stock.service.customer.CustomerInfoService;
@Service
public class CustomerInfoServiceImpl extends ServiceImpl<CustomerInfoMapper, CustomerInfo> implements CustomerInfoService{

}
