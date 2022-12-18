package com.jy.stock.service.system.operation.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.dao.entity.system.operation.OperationLog;
import com.jy.stock.dao.mapper.operation.OperationLogMapper;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.operation.OperationLogDTO;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import com.jy.stock.pojo.request.system.operation.AddOperationLogReq;
import com.jy.stock.pojo.request.system.operation.QueryOperationLogReq;
import com.jy.stock.service.system.operation.OperationLogService;
import com.jy.stock.service.system.user.UserInfoService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author liaojunyao
 */
@Service
public class OperationLogServiceImpl extends EnhancedServiceImpl<OperationLogMapper, OperationLog, OperationLogDTO> implements OperationLogService{

    @Resource
    private UserInfoService userInfoService;

    @Override
    @Async
    @Transactional(rollbackFor = Exception.class)
    public void addOperationLog(AddOperationLogReq request){
        // 异步线程之间传递request
        RequestContextHolder.setRequestAttributes(request.getRequestAttributes());
        OperationLog operationLog = new OperationLog();
        operationLog.setModule(request.getModule().getCode());
        operationLog.setSubModule(request.getSubModule().getCode());
        operationLog.setOperationType(request.getType().getCode());
        operationLog.setModuleBusinessId(request.getBusinessId());
        operationLog.setUserId(request.getUserId());
        operationLog.setOperationDesc(request.getDesc());
        save(operationLog);
    }

    @Override
    public PageDTO<OperationLogDTO> listOperationLogByPage(QueryOperationLogReq request) {
        Page<OperationLog> pageParam = new Page<>(request.getPageNo(), request.getPageSize());
        IPage<OperationLog> page = baseMapper.listOperationLogByPage(pageParam, request);
        return toPageDTO(page);
    }

    @Override
    protected List<OperationLogDTO> toDtoList(List<OperationLog> list) {
        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<>();
        }
        Set<Long> userIdSet = StreamUtils.mapCollectToSet(list, OperationLog::getUserId);
        Map<Long, UserInfoDTO> userInfoMap = userInfoService.batchListUserInfo(userIdSet);
        return StreamUtils.mapCollect(list, e -> {
            OperationLogDTO dto = super.toDto(e);
            dto.setOperateUser(userInfoMap.get(e.getUserId()));
            return dto;
        });
    }

    @Override
    public Class<OperationLogDTO> getDtoClass() {
        return OperationLogDTO.class;
    }
}
