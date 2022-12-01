package com.jy.stock.pojo.converter.goods;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.response.goods.GoodsInfoVO;
import com.jy.stock.pojo.response.goods.GoodsTypeVO;
import com.jy.stock.pojo.response.goods.GoodsUnitVO;

/**
 * @author liaojunyao
 */
public class GoodsConverter {

    public static GoodsTypeVO dtoToVo(GoodsTypeDTO dto) {
        if (dto == null){
            return null;
        }
        GoodsTypeVO vo = new GoodsTypeVO();
        BeanCopyUtils.copy(dto, vo);
        return vo;
    }

    public static GoodsUnitVO dtoToVo(GoodsUnitDTO dto) {
        if (dto == null){
            return null;
        }
        GoodsUnitVO vo = new GoodsUnitVO();
        BeanCopyUtils.copy(dto, vo);
        return vo;
    }

    public static GoodsInfoVO dtoToVo(GoodsInfoDTO dto) {
        if (dto == null){
            return null;
        }
        GoodsInfoVO vo = new GoodsInfoVO();
        BeanCopyUtils.copy(dto, vo);
        GoodsTypeVO goodsTypeVO = dtoToVo(dto.getGoodsType());
        GoodsUnitVO goodsUnitVO = dtoToVo(dto.getGoodsUnit());
        vo.setGoodsType(goodsTypeVO);
        vo.setGoodsUnit(goodsUnitVO);
        return vo;
    }

}
