package com.jy.stock.mapper.info;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.info.CustomerInfo;
import com.jy.stock.model.request.info.QueryCustomerInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author liaojunyao
 */
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

    Page<CustomerInfo> listCustomerInfoByPage(@Param("page") Page<CustomerInfo> pageParam, @Param("param") QueryCustomerInfoReq request);

}