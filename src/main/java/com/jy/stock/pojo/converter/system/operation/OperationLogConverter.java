package com.jy.stock.pojo.converter.system.operation;

import com.jy.stock.enums.system.operation.ModuleEnum;
import com.jy.stock.enums.system.operation.OperationTypeEnum;
import com.jy.stock.enums.system.operation.SubModuleEnum;
import com.jy.stock.pojo.converter.system.user.UserConverter;
import com.jy.stock.pojo.dto.system.operation.OperationLogDTO;
import com.jy.stock.pojo.response.system.operation.OperationLogVO;
import com.jy.stock.pojo.response.system.user.UserInfoVO;

/**
 * @author liaojunyao
 */
public class OperationLogConverter {

    public static OperationLogVO dtoToVo(OperationLogDTO dto) {
        if (dto == null){
            return null;
        }
        OperationLogVO vo = new OperationLogVO();
        vo.setId(dto.getId());
        vo.setModule(ModuleEnum.getByCode(dto.getModule()).getDesc());
        vo.setSubModule(SubModuleEnum.getByCode(dto.getSubModule()).getDesc());
        vo.setModuleBusinessId(dto.getModuleBusinessId());
        vo.setOperationType(OperationTypeEnum.getByCode(dto.getOperationType()).getDesc());
        vo.setOperationDesc(dto.getOperationDesc());
        UserInfoVO operateUser = UserConverter.dtoToVo(dto.getOperateUser());
        vo.setOperateUser(operateUser);
        vo.setCreateTime(dto.getCreateTime());
        return vo;
    }

}
