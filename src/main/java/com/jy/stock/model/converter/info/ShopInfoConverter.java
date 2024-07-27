package com.jy.stock.model.converter.info;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.converter.system.UserConverter;
import com.jy.stock.model.dto.info.ShopInfoDTO;
import com.jy.stock.model.vo.info.ShopInfoVO;
import com.jy.stock.model.vo.system.UserInfoVO;

/**
 * @author liaojunyao
 */
public class ShopInfoConverter {

    public static ShopInfoVO dtoToVo(ShopInfoDTO dto) {
        if (dto == null) {
            return null;
        }
        ShopInfoVO vo = new ShopInfoVO();
        BeanCopyUtils.copy(dto, vo);
        UserInfoVO createUser = UserConverter.dtoToVo(dto.getCreateUser());
        UserInfoVO updateUser = UserConverter.dtoToVo(dto.getUpdateUser());
        vo.setCreateUser(createUser);
        vo.setUpdateUser(updateUser);
        return vo;
    }

}
