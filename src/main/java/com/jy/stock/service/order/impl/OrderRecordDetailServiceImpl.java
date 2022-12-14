package com.jy.stock.service.order.impl;

import com.jy.stock.common.enhance.EnhancedServiceImpl;
import com.jy.stock.dao.entity.order.OrderRecordDetail;
import com.jy.stock.dao.mapper.order.OrderRecordDetailMapper;
import com.jy.stock.pojo.dto.order.OrderRecordDetailDTO;
import com.jy.stock.service.order.OrderRecordDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaojunyao
 */
@Service
public class OrderRecordDetailServiceImpl extends EnhancedServiceImpl<OrderRecordDetailMapper, OrderRecordDetail, OrderRecordDetailDTO> implements OrderRecordDetailService{

    @Override
    public int batchInsert(List<OrderRecordDetail> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Class<OrderRecordDetailDTO> getDtoClass() {
        return OrderRecordDetailDTO.class;
    }
}
