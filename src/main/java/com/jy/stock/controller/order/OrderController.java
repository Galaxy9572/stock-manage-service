package com.jy.stock.controller.order;

import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.enums.order.OrderTypeEnum;
import com.jy.stock.enums.order.PaymentMethodEnum;
import com.jy.stock.pojo.request.order.AddModifyOrderRecordReq;
import com.jy.stock.pojo.response.order.OrderRecordVO;
import com.jy.stock.pojo.response.order.OrderTypeVO;
import com.jy.stock.pojo.response.order.PaymentMethodVO;
import com.jy.stock.service.order.OrderRecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * (order_record)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderRecordService orderRecordService;

    @PostMapping("/record/list")
    public ResponseVO<PageVO<OrderRecordVO>> listOrderRecordsByPage(@Valid @RequestBody AddModifyOrderRecordReq request) {
        return ResponseVO.success();
    }

    @GetMapping("/type/list")
    public ResponseVO<List<OrderTypeVO>> listAllOrderTypes() {
        return ResponseVO.success(OrderTypeEnum.listAll());
    }

    @GetMapping("/payment-method/list")
    public ResponseVO<List<PaymentMethodVO>> listAllPaymentMethods() {
        return ResponseVO.success(PaymentMethodEnum.listAll());
    }

}
