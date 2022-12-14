package com.jy.stock.service.dashboard.impl;

import com.jy.stock.pojo.response.dashboard.DashboardStatisticVO;
import com.jy.stock.service.customer.CustomerInfoService;
import com.jy.stock.service.dashboard.DashboardService;
import com.jy.stock.service.goods.GoodsInfoService;
import com.jy.stock.service.supplier.SupplierInfoService;
import com.jy.stock.service.user.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liaojunyao
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Resource
    private UserInfoService userInfoService;

    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private CustomerInfoService customerInfoService;

    @Resource
    private SupplierInfoService supplierInfoService;

    @Override
    public DashboardStatisticVO getDashboardStatistic() {
        long userCount = userInfoService.count();
        long goodsCount = goodsInfoService.count();
        long customerCount = customerInfoService.count();
        long supplierCount = supplierInfoService.count();
        DashboardStatisticVO vo = new DashboardStatisticVO();
        vo.setUserCount(userCount);
        vo.setGoodsCount(goodsCount);
        vo.setCustomerCount(customerCount);
        vo.setSupplierCount(supplierCount);
        return vo;
    }

}
