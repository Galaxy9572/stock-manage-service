package com.jy.stock.service.user;

import java.util.List;
import com.jy.stock.dao.entity.user.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserInfoService extends IService<UserInfo>{


    int updateBatchSelective(List<UserInfo> list);

    int batchInsert(List<UserInfo> list);

}
