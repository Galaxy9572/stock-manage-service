package com.jy.stock.controller.order;

import com.jy.stock.common.response.CodeDescVO;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.enums.order.OrderTypeEnum;
import com.jy.stock.enums.order.PaymentMethodEnum;
import com.jy.stock.model.request.order.AddModifyOrderRecordReq;
import com.jy.stock.model.vo.order.OrderRecordVO;
import com.jy.stock.service.order.OrderRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (order_record)表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRecordService orderRecordService;

    @PostMapping("/record")
    public HttpResult<Boolean> addModifyOrderRecord(@Valid @RequestBody AddModifyOrderRecordReq request) {
        boolean isSuccess = orderRecordService.addOrderRecord(request);
        return HttpResult.success(isSuccess);
    }

    @PostMapping("/record/list")
    public HttpResult<PageVO<OrderRecordVO>> listOrderRecordsByPage(@Valid @RequestBody AddModifyOrderRecordReq request) {

        return HttpResult.success();
    }

    @GetMapping("/type/list")
    public HttpResult<List<CodeDescVO>> listAllOrderTypes() {
        return HttpResult.success(OrderTypeEnum.listAll());
    }

    @GetMapping("/payment-method/list")
    public HttpResult<List<CodeDescVO>> listAllPaymentMethods() {
        return HttpResult.success(PaymentMethodEnum.listAll());
    }

}
