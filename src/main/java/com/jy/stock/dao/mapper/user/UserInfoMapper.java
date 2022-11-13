package com.jy.stock.dao.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jy.stock.dao.entity.user.UserInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    int updateBatchSelective(List<UserInfo> list);

    int batchInsert(@Param("list") List<UserInfo> list);
}