package com.jy.stock.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.model.entity.order.OrderRecordDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderRecordDetailMapper extends BaseMapper<OrderRecordDetail> {
    int updateBatchSelective(List<OrderRecordDetail> list);

    int batchInsert(@Param("list") List<OrderRecordDetail> list);
}