package com.jy.stock.dao.mapper.info.customer;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.dao.entity.info.customer.CustomerInfo;
import com.jy.stock.pojo.request.info.customer.QueryCustomerInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    Page<CustomerInfo> listCustomerInfoByPage(@Param("page") Page<CustomerInfo> pageParam, @Param("param") QueryCustomerInfoReq request);

}