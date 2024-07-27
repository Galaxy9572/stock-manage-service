package com.jy.stock.model.converter.info;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.converter.system.UserConverter;
import com.jy.stock.model.dto.info.WarehouseInfoDTO;
import com.jy.stock.model.vo.info.WarehouseInfoVO;
import com.jy.stock.model.vo.system.UserInfoVO;

/**
 * @author liaojunyao
 */
public class WarehouseInfoConverter {

    public static WarehouseInfoVO dtoToVo(WarehouseInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        WarehouseInfoVO vo = new WarehouseInfoVO();
        BeanCopyUtils.copy(dto, vo);
        UserInfoVO createUser = UserConverter.dtoToVo(dto.getCreateUser());
        UserInfoVO updateUser = UserConverter.dtoToVo(dto.getUpdateUser());
        vo.setCreateUser(createUser);
        vo.setUpdateUser(updateUser);
        return vo;
    }

}
