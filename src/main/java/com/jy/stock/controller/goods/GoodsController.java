package com.jy.stock.controller.goods;

import com.jy.stock.service.goods.GoodsFacadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品信息控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsFacadeService goodsFacadeService;


}
