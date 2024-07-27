package com.jy.stock.controller.system;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.CodeDescVO;
import com.jy.stock.common.response.HttpResult;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.model.converter.system.OperationLogConverter;
import com.jy.stock.model.dto.PageDTO;
import com.jy.stock.model.dto.system.OperationLogDTO;
import com.jy.stock.model.request.system.QueryOperationLogReq;
import com.jy.stock.model.vo.system.OperationLogVO;
import com.jy.stock.service.system.OperationLogService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 操作记录控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/system/operation-log")
public class OperationLogController extends EnhancedController<OperationLogVO, OperationLogDTO> {

    @Autowired
    private OperationLogService operationLogService;

    @PostMapping("/list")
    public HttpResult<PageVO<OperationLogVO>> listOperationLogByPage(@RequestBody @Valid QueryOperationLogReq request) {
        PageDTO<OperationLogDTO> pageDTO = operationLogService.listOperationLogByPage(request);
        PageVO<OperationLogVO> pageVO = toPageVO(pageDTO);
        return HttpResult.success(pageVO);
    }

    @GetMapping("/module/list")
    public HttpResult<List<CodeDescVO>> listAllModules() {
        List<CodeDescVO> list = ModuleEnum.listAll();
        return HttpResult.success(list);
    }

    @GetMapping("/module/{module}/sub-module/list")
    public HttpResult<List<CodeDescVO>> listAllSubModules(@PathVariable String module) {
        ModuleEnum moduleEnum = ModuleEnum.getByCode(module);
        AssertUtils.isNotNull(moduleEnum, "param.invalid");
        List<CodeDescVO> list = SubModuleEnum.listByModule(moduleEnum);
        return HttpResult.success(list);
    }

    @GetMapping("/operation-type/list")
    public HttpResult<List<CodeDescVO>> listAllOperationTypes() {
        List<CodeDescVO> list = OperationTypeEnum.listAll();
        return HttpResult.success(list);
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
