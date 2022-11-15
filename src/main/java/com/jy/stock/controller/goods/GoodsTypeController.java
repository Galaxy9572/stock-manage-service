package com.jy.stock.controller.goods;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.response.goods.GoodsTypeVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品类型控制层
 * @author liaojunyao
 */
@RestController
@RequestMapping("/goods/type")
public class GoodsTypeController extends EnhancedController<GoodsTypeVO, GoodsTypeDTO> {

    

    @Override
    public Class<GoodsTypeVO> getVoClass() {
        return GoodsTypeVO.class;
    }
}
