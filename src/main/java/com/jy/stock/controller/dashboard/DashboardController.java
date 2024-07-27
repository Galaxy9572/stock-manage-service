package com.jy.stock.controller.dashboard;

import com.jy.stock.common.response.HttpResult;
import com.jy.stock.model.vo.dashboard.DashboardStatisticVO;
import com.jy.stock.service.dashboard.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liaojunyao
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/statistic")
    public HttpResult<DashboardStatisticVO> getDashboardStatistic() {
        DashboardStatisticVO vo = dashboardService.getDashboardStatistic();
        return HttpResult.success(vo);
    }

}
