package com.jy.stock.service.region.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.enums.RegionLevelEnum;
import com.jy.stock.common.exception.BusinessException;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.dao.entity.region.RegionInfo;
import com.jy.stock.dao.mapper.region.RegionInfoMapper;
import com.jy.stock.pojo.dto.region.RegionInfoDTO;
import com.jy.stock.pojo.request.region.QueryRegionRequest;
import com.jy.stock.service.region.RegionInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liaojunyao
 */
@Service
public class RegionInfoServiceImpl extends EnhancedServiceImpl<RegionInfoMapper, RegionInfo, RegionInfoDTO> implements RegionInfoService{

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<RegionInfoDTO> listRegions(QueryRegionRequest request) {
        RegionInfo param = new RegionInfo();
        BeanCopyUtils.copy(request, param);
        List<RegionInfoDTO> cacheList = listRegionsFromCache(param);
        if (CollectionUtils.isNotEmpty(cacheList)) {
            return cacheList;
        }
        List<RegionInfo> regionInfoList = baseMapper.listRegions(param);
        if(CollectionUtils.isEmpty(regionInfoList)){
            return new ArrayList<>();
        }
        List<RegionInfoDTO> dtoList = StreamUtils.mapCollect(regionInfoList, this::toDto);
        flushToCache(param, dtoList);
        return dtoList;
    }

    @Override
    public Class<RegionInfoDTO> getDtoClass() {
        return RegionInfoDTO.class;
    }

    private List<RegionInfoDTO> listRegionsFromCache(RegionInfo param) {
        String cacheKey = getCacheKey(param);
        List<Object> list = redisTemplate.opsForList().range(cacheKey, 0, -1);
        if(CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        return StreamUtils.mapCollect(list, e -> (RegionInfoDTO) e);
    }

    private void flushToCache(RegionInfo param, List<RegionInfoDTO> regionInfoList) {
        String cacheKey = getCacheKey(param);
        redisTemplate.opsForList().leftPushAll(cacheKey, regionInfoList);
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
}
