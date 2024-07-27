package com.jy.stock.model.converter.system;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.dto.system.UserInfoDTO;
import com.jy.stock.model.vo.system.UserInfoVO;

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
