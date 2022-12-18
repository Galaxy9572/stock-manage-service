package com.jy.stock.controller.system.operation;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.EnumCodeDescVO;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.enums.system.operation.ModuleEnum;
import com.jy.stock.enums.system.operation.OperationTypeEnum;
import com.jy.stock.enums.system.operation.SubModuleEnum;
import com.jy.stock.pojo.converter.system.operation.OperationLogConverter;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.operation.OperationLogDTO;
import com.jy.stock.pojo.request.system.operation.QueryOperationLogReq;
import com.jy.stock.pojo.response.system.operation.OperationLogVO;
import com.jy.stock.service.system.operation.OperationLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 操作记录控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/system/operation-log")
public class OperationLogController extends EnhancedController<OperationLogVO, OperationLogDTO> {

    @Resource
    private OperationLogService operationLogService;

    @PostMapping("/list")
    public ResponseVO<PageVO<OperationLogVO>> listOperationLogByPage(@RequestBody @Valid QueryOperationLogReq request) {
        PageDTO<OperationLogDTO> pageDTO = operationLogService.listOperationLogByPage(request);
        PageVO<OperationLogVO> pageVO = toPageVO(pageDTO);
        return ResponseVO.success(pageVO);
    }

    @GetMapping("/module/list")
    public ResponseVO<List<EnumCodeDescVO>> listAllModules() {
        List<EnumCodeDescVO> list = ModuleEnum.listAll();
        return ResponseVO.success(list);
    }

    @GetMapping("/module/{module}/sub-module/list")
    public ResponseVO<List<EnumCodeDescVO>> listAllSubModules(@PathVariable String module) {
        ModuleEnum moduleEnum = ModuleEnum.getByCode(module);
        AssertUtils.isNotNull(moduleEnum, "param.invalid");
        List<EnumCodeDescVO> list = SubModuleEnum.listByModule(moduleEnum);
        return ResponseVO.success(list);
    }

    @GetMapping("/operation-type/list")
    public ResponseVO<List<EnumCodeDescVO>> listAllOperationTypes() {
        List<EnumCodeDescVO> list = OperationTypeEnum.listAll();
        return ResponseVO.success(list);
    }

    @Override
    protected OperationLogVO toVo(OperationLogDTO operationLogDTO) {
        return OperationLogConverter.dtoToVo(operationLogDTO);
    }

    @Override
    public Class<OperationLogVO> getVoClass() {
        return OperationLogVO.class;
    }
}
