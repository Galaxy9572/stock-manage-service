package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.goods.GoodsInfo;
import com.jy.stock.dao.mapper.goods.GoodsInfoMapper;
import com.jy.stock.pojo.dto.goods.GoodsInfoDTO;
import com.jy.stock.pojo.request.goods.AddModifyGoodsInfoReq;
import com.jy.stock.service.goods.GoodsInfoService;
import com.jy.stock.service.goods.GoodsTypeService;
import com.jy.stock.service.goods.GoodsUnitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品信息服务
 * @author liaojunyao
 */
@Service
public class GoodsInfoServiceImpl extends EnhancedServiceImpl<GoodsInfoMapper, GoodsInfo, GoodsInfoDTO> implements GoodsInfoService{

    @Resource
    private GoodsTypeService goodsTypeService;

    @Resource
    private GoodsUnitService goodsUnitService;

    @Override
    public GoodsInfoDTO addModifyGoodsInfo(AddModifyGoodsInfoReq request) {
        boolean isSuccess;
        Long id;
        goodsTypeService.checkExistenceById(request.getGoodsTypeId(), true);
        goodsUnitService.checkExistenceById(request.getGoodsUnitId(), true);
        if (request.getId() == null) {
            // 新增
            GoodsInfo goodsInfo = new GoodsInfo();
            BeanCopyUtils.copy(request, goodsInfo);
            isSuccess = save(goodsInfo);
            id = goodsInfo.getId();
        } else {
            // 修改

        }
        return
    }

    @Override
    public GoodsInfoDTO checkExistenceByName(String goodsName, boolean assertExists) {
        LambdaQueryWrapper<GoodsInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsInfo::getGoodsName, goodsName);
        GoodsInfo goodsInfo = getOne(queryWrapper);
        if (assertExists) {
            AssertUtils.isNotNull(goodsInfo, "goods.info.not.exist");
        } else {
            AssertUtils.isNull(goodsInfo, "goods.info.already.exists");
        }
        return toDto(goodsInfo);
    }

    @Override
    public GoodsInfoDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsInfo goodsInfo = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsInfo, "goods.info.not.exist");
        } else {
            AssertUtils.isNull(goodsInfo, "goods.info.already.exists");
        }
        return toDto(goodsInfo);
    }

    @Override
    public Class<GoodsInfoDTO> getDtoClass() {
        return GoodsInfoDTO.class;
    }
}
