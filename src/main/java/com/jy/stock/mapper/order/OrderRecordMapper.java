package com.jy.stock.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.model.entity.order.OrderRecord;
import com.jy.stock.model.request.order.QueryOrderRecordReq;
import org.apache.ibatis.annotations.Param;

/**
 * 订单记录 Mapper 接口
 * @author JY
 */
public interface OrderRecordMapper extends BaseMapper<OrderRecord> {

    /**
     * 分页查询订单记录
     * @param page 分页信息
     * @param request 查询条件
     * @return 分页结果
     */
    IPage<OrderRecord> listOrderRecordByPage(@Param("page") Page<OrderRecord> page, @Param("param") QueryOrderRecordReq request);

}
