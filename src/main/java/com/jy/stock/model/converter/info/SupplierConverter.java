package com.jy.stock.model.converter.info;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.converter.system.UserConverter;
import com.jy.stock.model.dto.info.SupplierInfoDTO;
import com.jy.stock.model.vo.info.SupplierInfoVO;
import com.jy.stock.model.vo.system.UserInfoVO;

/**
 * @author liaojunyao
 */
public class SupplierConverter {

    public static SupplierInfoVO dtoToVo(SupplierInfoDTO dto) {
        if (dto == null){
            return null;
        }
        SupplierInfoVO vo = new SupplierInfoVO();
        BeanCopyUtils.copy(dto, vo);
        UserInfoVO createUserVO = UserConverter.dtoToVo(dto.getCreateUser());
        UserInfoVO updateUserVO = UserConverter.dtoToVo(dto.getUpdateUser());
        vo.setCreateUser(createUserVO);
        vo.setUpdateUser(updateUserVO);
        return vo;
    }

}
