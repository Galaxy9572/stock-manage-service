package com.jy.stock.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.dao.entity.order.OrderRecord;
import com.jy.stock.pojo.request.order.AddModifyOrderRecordReq;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRecordService extends IService<OrderRecord>{

    @Transactional(rollbackFor = Exception.class)
    boolean addOrderRecord(AddModifyOrderRecordReq request);
}
