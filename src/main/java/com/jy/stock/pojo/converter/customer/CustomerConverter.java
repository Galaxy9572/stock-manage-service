package com.jy.stock.pojo.converter.customer;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.system.user.UserConverter;
import com.jy.stock.pojo.dto.customer.CustomerInfoDTO;
import com.jy.stock.pojo.response.customer.CustomerInfoVO;
import com.jy.stock.pojo.response.system.user.UserInfoVO;

/**
 * @author liaojunyao
 */
public class CustomerConverter {

    public static CustomerInfoVO dtoToVo(CustomerInfoDTO dto) {
        if (dto == null){
            return null;
        }
        CustomerInfoVO vo = new CustomerInfoVO();
        BeanCopyUtils.copy(dto, vo);
        UserInfoVO createUserVO = UserConverter.dtoToVo(dto.getCreateUser());
        UserInfoVO updateUserVO = UserConverter.dtoToVo(dto.getUpdateUser());
        vo.setCreateUser(createUserVO);
        vo.setUpdateUser(updateUserVO);
        return vo;
    }

}
