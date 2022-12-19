package com.jy.stock.pojo.converter.info.supplier;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.system.user.UserConverter;
import com.jy.stock.pojo.dto.info.SupplierInfoDTO;
import com.jy.stock.pojo.response.info.SupplierInfoVO;
import com.jy.stock.pojo.response.system.UserInfoVO;

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
