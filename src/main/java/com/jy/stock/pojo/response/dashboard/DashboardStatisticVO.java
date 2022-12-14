package com.jy.stock.pojo.response.dashboard;

import lombok.Data;

/**
 * @author liaojunyao
 */
@Data
public class DashboardStatisticVO {

    private Long userCount;

    private Long goodsCount;

    private Long customerCount;
    
    private Long supplierCount;

}
