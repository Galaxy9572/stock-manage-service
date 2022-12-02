package com.jy.stock.service.region.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.stock.dao.mapper.region.RegionInfoMapper;
import com.jy.stock.dao.entity.region.RegionInfo;
import com.jy.stock.service.region.RegionInfoService;
@Service
public class RegionInfoServiceImpl extends ServiceImpl<RegionInfoMapper, RegionInfo> implements RegionInfoService{

}
