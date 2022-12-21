package com.jy.stock.controller.dashboard;

import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.pojo.vo.dashboard.DashboardStatisticVO;
import com.jy.stock.service.dashboard.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liaojunyao
 */
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Resource
    private DashboardService dashboardService;

    @GetMapping("/statistic")
    public ResponseVO<DashboardStatisticVO> getDashboardStatistic() {
        DashboardStatisticVO vo = dashboardService.getDashboardStatistic();
        return ResponseVO.success(vo);
    }

}
