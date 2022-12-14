package com.jy.stock.pojo.converter.info;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.system.UserConverter;
import com.jy.stock.pojo.dto.info.CustomerInfoDTO;
import com.jy.stock.pojo.vo.info.CustomerInfoVO;
import com.jy.stock.pojo.vo.system.UserInfoVO;

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
