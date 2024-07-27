package com.jy.stock.service.order.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.common.util.TimeUtils;
import com.jy.stock.mapper.order.OrderRecordMapper;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.order.OrderRecordDTO;
import com.jy.stock.model.entity.order.OrderRecord;
import com.jy.stock.model.request.order.AddModifyOrderRecordReq;
import com.jy.stock.model.request.order.QueryOrderRecordReq;
import com.jy.stock.service.order.OrderRecordDetailService;
import com.jy.stock.service.order.OrderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author liaojunyao
 */
@Service
public class OrderRecordServiceImpl extends EnhancedServiceImpl<OrderRecordMapper, OrderRecord, OrderRecordDTO> implements OrderRecordService{

    @Autowired
    private OrderRecordDetailService orderRecordDetailService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrderRecord(AddModifyOrderRecordReq request) {
        String orderId = generateOrderId();

        return true;
    }

    @Override
    public PageDTO<OrderRecordDTO> listOrderRecordByPage(QueryOrderRecordReq request){
        var pageParam = new Page<OrderRecord>(request.getPageNo(), request.getPageSize());
        IPage<OrderRecord> page = baseMapper.listOrderRecordByPage(pageParam, request);
        return toPageDTO(page);
    }

    public String generateOrderId() {
        String prefix = TimeUtils.toTimeString(LocalDateTime.now(), TimeUtils.ORDER_ID_PREFIX_FORMATTER);
        String salt = HashUtils.randomSalt();
        return prefix + salt;
    }

    @Override
    public Class<OrderRecordDTO> getDtoClass() {
        return OrderRecordDTO.class;
    }
}
