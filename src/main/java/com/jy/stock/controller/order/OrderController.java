package com.jy.stock.controller.order;

import com.jy.stock.common.response.EnumCodeDescVO;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.enums.order.OrderTypeEnum;
import com.jy.stock.enums.order.PaymentMethodEnum;
import com.jy.stock.pojo.request.order.AddModifyOrderRecordReq;
import com.jy.stock.pojo.vo.order.OrderRecordVO;
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

    @PostMapping("/record")
    public ResponseVO<Boolean> addModifyOrderRecord(@Valid @RequestBody AddModifyOrderRecordReq request) {
        boolean isSuccess = orderRecordService.addOrderRecord(request);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/record/list")
    public ResponseVO<PageVO<OrderRecordVO>> listOrderRecordsByPage(@Valid @RequestBody AddModifyOrderRecordReq request) {

        return ResponseVO.success();
    }

    @GetMapping("/type/list")
    public ResponseVO<List<EnumCodeDescVO>> listAllOrderTypes() {
        return ResponseVO.success(OrderTypeEnum.listAll());
    }

    @GetMapping("/payment-method/list")
    public ResponseVO<List<EnumCodeDescVO>> listAllPaymentMethods() {
        return ResponseVO.success(PaymentMethodEnum.listAll());
    }

}
