package com.jy.stock.common.aspect;

import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.util.ContextHolder;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.pojo.request.AddModifyRequest;
import com.jy.stock.pojo.request.system.AddOperationLogReq;
import com.jy.stock.service.system.OperationLogService;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liaojunyao
 */
@Aspect
@Component
@Order(1)
public class OperationLogAspect {

    @Resource
    private OperationLogService operationLogService;

    @Pointcut("execution(public com.jy.stock.common.response.ResponseVO com.jy.stock.controller..*.*.*(..))" +
            " && @annotation(com.jy.stock.common.aspect.annotation.OperationLog)")
    public void pointCut() {

    }

    @Around(value = "pointCut() && @annotation(log)")
    public Object log(ProceedingJoinPoint point, OperationLog log) throws Throwable {
        Object[] args = point.getArgs();
        Map<String, Object> param = new HashMap<>(16);
        Object[] paramValues = point.getArgs();
        String[] paramNames = ((CodeSignature) point.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }
        Long loginUserId = ContextHolder.currentUserId();
        OperationTypeEnum operationType = log.operationType();
        Long id = null;
        AddOperationLogReq request = new AddOperationLogReq();
        ResponseVO<?> result = (ResponseVO<?>) point.proceed();
        if(result.getCode() != HttpStatus.OK.value()){
            return result;
        }
        if (OperationTypeEnum.isAddOrModify(operationType.getCode())) {
            AddModifyRequest addModifyReq = (AddModifyRequest) Arrays.stream(args).filter(e -> e instanceof AddModifyRequest).findFirst().orElse(null);
            if (addModifyReq != null) {
                if (addModifyReq.getId() != null) {
                    id = addModifyReq.getId();
                    request.setType(OperationTypeEnum.UPDATE);
                } else {
                    Object data = result.getData();
                    id = Long.valueOf(BeanUtils.getProperty(data,"id"));
                    request.setType(OperationTypeEnum.ADD);
                }
            }
        } else if (OperationTypeEnum.DELETE == operationType) {
            request.setType(OperationTypeEnum.DELETE);
            id = (Long) param.get("id");
        }
        request.setRequestAttributes(RequestContextHolder.getRequestAttributes());
        request.setBusinessId(id);
        request.setModule(log.module());
        request.setSubModule(log.subModule());
        request.setUserId(loginUserId);
        request.setDesc(String.format("%s%s模块中%s子模块的数据", request.getType().getDesc(), log.module().getDesc(), log.subModule().getDesc()));
        operationLogService.addOperationLog(request);
        return result;
    }

}
