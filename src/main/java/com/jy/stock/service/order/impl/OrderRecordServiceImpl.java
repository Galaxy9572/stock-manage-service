package com.jy.stock.service.order.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.common.util.HashUtils;
import com.jy.stock.common.util.TimeUtils;
import com.jy.stock.dao.entity.order.OrderRecord;
import com.jy.stock.dao.mapper.order.OrderRecordMapper;
import com.jy.stock.pojo.dto.order.OrderRecordDTO;
import com.jy.stock.pojo.request.order.AddModifyOrderRecordReq;
import com.jy.stock.service.order.OrderRecordDetailService;
import com.jy.stock.service.order.OrderRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author liaojunyao
 */
@Service
public class OrderRecordServiceImpl extends EnhancedServiceImpl<OrderRecordMapper, OrderRecord, OrderRecordDTO> implements OrderRecordService{

    @Resource
    private OrderRecordDetailService orderRecordDetailService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addOrderRecord(AddModifyOrderRecordReq request) {
        String orderId = generateOrderId();

        return true;
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
