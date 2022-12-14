package com.jy.stock.service.order.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.order.OrderRecord;
import com.jy.stock.dao.mapper.order.OrderRecordMapper;
import com.jy.stock.pojo.dto.order.OrderRecordDTO;
import com.jy.stock.pojo.request.order.AddModifyOrderRecordReq;
import com.jy.stock.service.order.OrderRecordDetailService;
import com.jy.stock.service.order.OrderRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author liaojunyao
 */
@Service
public class OrderRecordServiceImpl extends EnhancedServiceImpl<OrderRecordMapper, OrderRecord, OrderRecordDTO> implements OrderRecordService{

    @Resource
    private OrderRecordDetailService orderRecordDetailService;

    @Transactional(rollbackFor = Exception.class)
    public boolean addOrderRecord(AddModifyOrderRecordReq request) {

        return true;
    }

    @Override
    public Class<OrderRecordDTO> getDtoClass() {
        return OrderRecordDTO.class;
    }
}
