package com.jy.stock.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.order.OrderRecord;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.order.OrderRecordDTO;
import com.jy.stock.model.request.order.AddModifyOrderRecordReq;
import com.jy.stock.model.request.order.QueryOrderRecordReq;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRecordService extends IService<OrderRecord>{

    @Transactional(rollbackFor = Exception.class)
    boolean addOrderRecord(AddModifyOrderRecordReq request);

    PageDTO<OrderRecordDTO> listOrderRecordByPage(QueryOrderRecordReq request);
}
