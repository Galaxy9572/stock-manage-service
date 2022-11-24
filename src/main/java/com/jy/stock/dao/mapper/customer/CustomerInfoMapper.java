package com.jy.stock.dao.mapper.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.customer.CustomerInfo;
import com.jy.stock.pojo.request.customer.QueryCustomerInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    Page<CustomerInfo> listCustomerInfoByPage(@Param("page") Page<CustomerInfo> pageParam, @Param("param") QueryCustomerInfoReq request);

}