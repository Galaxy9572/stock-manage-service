package com.jy.stock.service.goods.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.mapper.goods.GoodsInfoMapper;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.goods.GoodsInfoDTO;
import com.jy.stock.model.dto.goods.GoodsTypeDTO;
import com.jy.stock.model.dto.goods.GoodsUnitDTO;
import com.jy.stock.model.dto.system.UserInfoDTO;
import com.jy.stock.model.entity.goods.GoodsInfo;
import com.jy.stock.model.request.goods.AddModifyGoodsInfoReq;
import com.jy.stock.model.request.goods.QueryGoodsInfoReq;
import com.jy.stock.service.goods.GoodsInfoService;
import com.jy.stock.service.goods.GoodsTypeService;
import com.jy.stock.service.goods.GoodsUnitService;
import com.jy.stock.service.system.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 商品信息服务
 *
 * @author liaojunyao
 */
@Service
public class GoodsInfoServiceImpl extends EnhancedServiceImpl<GoodsInfoMapper, GoodsInfo, GoodsInfoDTO> implements GoodsInfoService {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @Autowired
    private GoodsUnitService goodsUnitService;

    @Autowired
    private UserInfoService userInfoService;

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
            GoodsInfo goodsInfo = new GoodsInfo();
            BeanCopyUtils.copy(request, goodsInfo);
            isSuccess = updateById(goodsInfo);
            id = request.getId();
        }
        AssertUtils.isTrue(isSuccess, "operate.failed");
        return toDto(getById(id));
    }

    @Override
    public PageDTO<GoodsInfoDTO> listGoodsInfo(QueryGoodsInfoReq request){
        Page<GoodsInfo> page = new Page<>(request.getPageNo(), request.getPageSize());
        GoodsInfo param = new GoodsInfo();
        BeanCopyUtils.copy(request, param);
        IPage<GoodsInfo> pageResult = baseMapper.listGoodsInfo(page, param);
        return toPageDTO(pageResult);
    }

    @Override
    public GoodsInfoDTO getGoodsInfoDetail(Long id) {
        return checkExistenceById(id, true);
    }

    @Override
    public boolean deleteGoodsInfo(Long id) {
        checkExistenceById(id, true);
        return removeById(id);
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
        return goodsInfo != null ? toDto(goodsInfo) : null;
    }

    @Override
    public GoodsInfoDTO checkExistenceById(Long id, boolean assertExists) {
        GoodsInfo goodsInfo = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(goodsInfo, "goods.info.not.exist");
        } else {
            AssertUtils.isNull(goodsInfo, "goods.info.already.exists");
        }
        return goodsInfo != null ? toDto(goodsInfo) : null;
    }

    @Override
    public Class<GoodsInfoDTO> getDtoClass() {
        return GoodsInfoDTO.class;
    }

    @Override
    protected GoodsInfoDTO toDto(GoodsInfo goodsInfo) {
        if (goodsInfo == null) {
            return null;
        }
        GoodsTypeDTO goodsTypeDTO = goodsTypeService.getGoodsTypeById(goodsInfo.getGoodsTypeId());
        GoodsUnitDTO goodsUnitDTO = goodsUnitService.getGoodsUnitById(goodsInfo.getGoodsUnitId());
        GoodsInfoDTO goodsInfoDTO = super.toDto(goodsInfo);
        goodsInfoDTO.setGoodsType(goodsTypeDTO);
        goodsInfoDTO.setGoodsUnit(goodsUnitDTO);
        return goodsInfoDTO;
    }

    @Override
    protected List<GoodsInfoDTO> toDtoList(List<GoodsInfo> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        List<Long> goodsTypeIdList = StreamUtils.mapCollect(list, GoodsInfo::getGoodsTypeId);
        List<Long> goodsUnitIdList = StreamUtils.mapCollect(list, GoodsInfo::getGoodsUnitId);
        Map<Long, GoodsTypeDTO> goodsTypeMap = goodsTypeService.batchListGoodsType(goodsTypeIdList);
        Map<Long, GoodsUnitDTO> goodsUnitMap = goodsUnitService.batchListGoodsUnit(goodsUnitIdList);
        Set<Long> userIdSet = new HashSet<>();
        list.forEach(u -> {
            userIdSet.add(u.getCreateUserId());
            userIdSet.add(u.getUpdateUserId());
        });
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        return StreamUtils.mapCollect(list, e -> {
            GoodsInfoDTO goodsInfoDTO = super.toDto(e);
            goodsInfoDTO.setGoodsType(goodsTypeMap.get(e.getGoodsTypeId()));
            goodsInfoDTO.setGoodsUnit(goodsUnitMap.get(e.getGoodsUnitId()));
            goodsInfoDTO.setCreateUser(userInfoMap.get(e.getCreateUserId()));
            goodsInfoDTO.setUpdateUser(userInfoMap.get(e.getUpdateUserId()));
            return goodsInfoDTO;
        });
    }
}
