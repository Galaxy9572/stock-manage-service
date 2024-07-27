package com.jy.stock.service.dashboard.impl;

import com.jy.stock.model.vo.dashboard.DashboardStatisticVO;
import com.jy.stock.service.dashboard.DashboardService;
import com.jy.stock.service.goods.GoodsInfoService;
import com.jy.stock.service.info.CustomerInfoService;
import com.jy.stock.service.info.SupplierInfoService;
import com.jy.stock.service.system.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liaojunyao
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Autowired
    private CustomerInfoService customerInfoService;

    @Autowired
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
