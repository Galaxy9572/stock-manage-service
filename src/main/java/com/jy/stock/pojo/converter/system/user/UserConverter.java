package com.jy.stock.pojo.converter.system.user;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.dto.system.user.UserInfoDTO;
import com.jy.stock.pojo.response.system.user.UserInfoVO;

/**
 * @author liaojunyao
 */
public class UserConverter {

    public static UserInfoVO dtoToVo(UserInfoDTO dto) {
        if (dto == null){
            return null;
        }
        UserInfoVO vo = new UserInfoVO();
        BeanCopyUtils.copy(dto, vo);
        return vo;
    }

}
