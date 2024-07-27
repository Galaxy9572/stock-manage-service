package com.jy.stock.service.region.impl;

import com.alibaba.fastjson.JSONObject;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.exception.BusinessException;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.enums.region.RegionLevelEnum;
import com.jy.stock.mapper.region.RegionInfoMapper;
import com.jy.stock.model.dto.region.RegionInfoDTO;
import com.jy.stock.model.entity.region.RegionInfo;
import com.jy.stock.model.request.region.QueryRegionRequest;
import com.jy.stock.service.region.RegionInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author liaojunyao
 */
@Service
public class RegionInfoServiceImpl extends EnhancedServiceImpl<RegionInfoMapper, RegionInfo, RegionInfoDTO> implements RegionInfoService{

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public List<RegionInfoDTO> listRegions(QueryRegionRequest request) {
        RegionInfo param = new RegionInfo();
        BeanCopyUtils.copy(request, param);
        List<RegionInfoDTO> cacheList = listRegionsFromCache(param);
        if (CollectionUtils.isNotEmpty(cacheList)) {
            return sort(cacheList, request.getLevel());
        }
        List<RegionInfo> regionInfoList = baseMapper.listRegions(param);
        if(CollectionUtils.isEmpty(regionInfoList)){
            return new ArrayList<>();
        }
        List<RegionInfoDTO> dtoList = StreamUtils.mapCollect(regionInfoList, this::toDto);
        flushToCache(param, dtoList);
        return sort(dtoList, request.getLevel());
    }

    public void updateGeoData() {

    }

    @Override
    public Class<RegionInfoDTO> getDtoClass() {
        return RegionInfoDTO.class;
    }

    private List<RegionInfoDTO> listRegionsFromCache(RegionInfo param) {
        String cacheKey = getCacheKey(param);
        List<String> list = redisTemplate.opsForList().range(cacheKey, 0, -1);
        if(CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return StreamUtils.mapCollect(list, e -> JSONObject.parseObject(e, RegionInfoDTO.class));
    }

    @SuppressWarnings("unchecked")
    private void flushToCache(RegionInfo param, List<RegionInfoDTO> regionInfoList) {
        if(CollectionUtils.isEmpty(regionInfoList)) {
            return;
        }
        String cacheKey = getCacheKey(param);
        redisTemplate.executePipelined((RedisCallback<?>) connection -> {
            regionInfoList.forEach(e -> connection.listCommands().lPush(cacheKey.getBytes(), JSONObject.toJSONString(e).getBytes()));
            return null;
        });
    }

    private static String getCacheKey(RegionInfo param) {
        RegionLevelEnum levelEnum = RegionLevelEnum.getByCode(param.getLevel());
        AssertUtils.isNotNull(levelEnum, "region.level.invalid");
        switch (levelEnum) {
            case COUNTRY -> {
                return "region:country";
            }
            case STATE -> {
                String countryCode = param.getCountryCode();
                AssertUtils.isNotBlank(countryCode, "country.code.can.not.empty");
                return String.format("region:country:%s:state", countryCode);
            }
            case CITY -> {
                String countryCode = param.getCountryCode();
                AssertUtils.isNotBlank(countryCode, "country.code.can.not.empty");
                String stateCode = param.getStateCode();
                AssertUtils.isNotBlank(stateCode, "state.code.can.not.empty");
                return String.format("region:country:%s:state:%s:city", countryCode, stateCode);
            }
            case DISTRICT -> {
                String countryCode = param.getCountryCode();
                AssertUtils.isNotBlank(countryCode, "country.code.can.not.empty");
                String stateCode = param.getStateCode();
                AssertUtils.isNotBlank(stateCode, "state.code.can.not.empty");
                String cityCode = param.getCityCode();
                AssertUtils.isNotBlank(cityCode, "city.code.can.not.empty");
                return String.format("region:country:%s:state:%s:city:%s:district", countryCode, stateCode, cityCode);
            }
            default -> throw BusinessException.of("param.invalid");
        }
    }

    private static List<RegionInfoDTO> sort(List<RegionInfoDTO> list, String level) {
        RegionLevelEnum levelEnum = RegionLevelEnum.getByCode(level);
        AssertUtils.isNotNull(levelEnum, "region.level.invalid");
        switch (levelEnum) {
            case COUNTRY -> {
                list.sort(Comparator.comparing(RegionInfoDTO::getCountryCode));
                return list;
            }
            case STATE -> {
                list.sort(Comparator.comparing(e -> Integer.parseInt(e.getStateCode())));
                return list;
            }
            case CITY -> {
                list.sort(Comparator.comparing(e -> Integer.parseInt(e.getCityCode())));
                return list;
            }
            case DISTRICT -> {
                list.sort(Comparator.comparing(e -> Integer.parseInt(e.getDistrictCode())));
                return list;
            }
            default -> throw BusinessException.of("param.invalid");
        }
    }
}
