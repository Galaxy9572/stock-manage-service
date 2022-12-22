package com.jy.stock.pojo.converter.info;

import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.converter.system.UserConverter;
import com.jy.stock.pojo.dto.info.ShopInfoDTO;
import com.jy.stock.pojo.vo.info.ShopInfoVO;
import com.jy.stock.pojo.vo.system.UserInfoVO;

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
