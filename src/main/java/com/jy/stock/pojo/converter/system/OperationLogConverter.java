package com.jy.stock.pojo.converter.system;

import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.pojo.dto.system.OperationLogDTO;
import com.jy.stock.pojo.vo.system.OperationLogVO;
import com.jy.stock.pojo.vo.system.UserInfoVO;

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
        vo.setOperationType(dto.getOperationType());
        vo.setOperationTypeDesc(OperationTypeEnum.getByCode(dto.getOperationType()).getDesc());
        vo.setOperationDesc(dto.getOperationDesc());
        UserInfoVO operateUser = UserConverter.dtoToVo(dto.getOperateUser());
        vo.setOperateUser(operateUser);
        vo.setCreateTime(dto.getCreateTime());
        return vo;
    }

}
