package com.jy.stock.pojo.converter.supplier;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.user.UserConverter;
import com.jy.stock.pojo.dto.supplier.SupplierInfoDTO;
import com.jy.stock.pojo.response.supplier.SupplierInfoVO;
import com.jy.stock.pojo.response.user.UserInfoVO;

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