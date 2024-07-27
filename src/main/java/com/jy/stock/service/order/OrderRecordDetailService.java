package com.jy.stock.service.order;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jy.stock.model.entity.order.OrderRecordDetail;

import java.util.List;
public interface OrderRecordDetailService extends IService<OrderRecordDetail>{

    int batchInsert(List<OrderRecordDetail> list);

}
