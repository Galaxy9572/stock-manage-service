package com.jy.stock.service.user.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.user.UserInfo;
import com.jy.stock.dao.mapper.user.UserInfoMapper;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.service.user.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息服务
 * @author liaojunyao
 */
@Service
public class UserInfoServiceImpl extends EnhancedServiceImpl<UserInfoMapper, UserInfo, UserInfoDTO> implements UserInfoService {

    @Override
    public int updateBatchSelective(List<UserInfo> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<UserInfo> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<UserInfoDTO> getDtoClass() {
        return UserInfoDTO.class;
    }
}
