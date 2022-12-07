package com.jy.stock.pojo.converter.goods;

import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.user.UserConverter;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.dto.goods.GoodsTypeDTO;
import com.jy.stock.pojo.dto.goods.GoodsUnitDTO;
import com.jy.stock.pojo.response.goods.GoodsInfoVO;
import com.jy.stock.pojo.response.goods.GoodsTypeVO;
import com.jy.stock.pojo.response.goods.GoodsUnitVO;
import com.jy.stock.pojo.response.user.UserInfoVO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
        UserInfoVO createUserInfoVO = UserConverter.dtoToVo(dto.getCreateUser());
        UserInfoVO updateUserInfoVO = UserConverter.dtoToVo(dto.getUpdateUser());
        vo.setGoodsType(goodsTypeVO);
        vo.setGoodsUnit(goodsUnitVO);
        vo.setCreateUser(createUserInfoVO);
        vo.setUpdateUser(updateUserInfoVO);
        return vo;
    }

    public static List<GoodsTypeVO> dtoListToVoList(List<GoodsTypeDTO> goodsTypeList) {
        if (CollectionUtils.isEmpty(goodsTypeList)) {
            return new ArrayList<>();
        }
        List<GoodsTypeVO> resultList = new ArrayList<>();
        for (GoodsTypeDTO goodsType : goodsTypeList) {
            String[] idPathArray = goodsType.getPath().split("!");
            List<GoodsTypeVO> currentList = resultList;
            for (String currentIdStr : idPathArray) {
                GoodsTypeVO node = StreamUtils.findFirst(currentList, e -> e.getId().toString().equals(currentIdStr));
                if (node == null) {
                    GoodsTypeVO vo = new GoodsTypeVO();
                    BeanCopyUtils.copy(goodsType, vo);
                    vo.setCreateUser(UserConverter.dtoToVo(goodsType.getCreateUser()));
                    vo.setUpdateUser(UserConverter.dtoToVo(goodsType.getUpdateUser()));
                    vo.setChildren(new ArrayList<>());
                    currentList.add(vo);
                    currentList = vo.getChildren();
                } else {
                    currentList = node.getChildren();
                }
            }
        }
        return resultList;
    }

}
