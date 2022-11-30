package com.jy.stock.controller.supplier;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.pojo.dto.supplier.SupplierInfoDTO;
import com.jy.stock.pojo.supplier.SupplierInfoVO;
import com.jy.stock.service.supplier.SupplierInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 供应商信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/supplier/info")
public class SupplierInfoController extends EnhancedController<SupplierInfoVO, SupplierInfoDTO> {
    /**
     * 服务对象
     */
    @Resource
    private SupplierInfoService supplierInfoService;


    @Override
    public Class<SupplierInfoVO> getVoClass() {
        return SupplierInfoVO.class;
    }
}
