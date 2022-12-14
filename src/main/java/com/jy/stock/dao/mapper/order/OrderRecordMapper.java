package com.jy.stock.dao.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.order.OrderRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderRecordMapper extends BaseMapper<OrderRecord> {
    int updateBatchSelective(List<OrderRecord> list);

    int batchInsert(@Param("list") List<OrderRecord> list);
}