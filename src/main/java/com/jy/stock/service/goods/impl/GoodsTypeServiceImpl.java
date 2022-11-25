package com.jy.stock.service.goods.impl;

import com.jy.stock.common.util.SnowflakeIdGenerator;
import com.jy.stock.dao.entity.goods.GoodsType;
import com.jy.stock.pojo.request.goods.AddModifyGoodsTypeReq;
import com.jy.stock.service.goods.GoodsTypeService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 商品类别服务
 *
 * @author liaojunyao
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Resource
    private MongoTemplate mongoTemplate;

    private static final SnowflakeIdGenerator SNOWFLAKE_ID_GENERATOR = new SnowflakeIdGenerator();

    @Override
    public void addModifyGoodsType(AddModifyGoodsTypeReq request) {
        GoodsType goodsType = new GoodsType();
        if (request.getId() == null) {
            // 新增
            if (request.getParentId() != null) {
                buildEntity(request, goodsType);
                Query query = Query.query(Criteria.where("id").is(request.getParentId()));
                Update update = new Update();
                update.addToSet("children", goodsType);
                mongoTemplate.upsert(query, update, GoodsType.class);
            } else {
                buildEntity(request, goodsType);
                mongoTemplate.save(goodsType);
            }
        } else {
            // 修改
            Query query = Query.query(Criteria.where("id").is(request.getId()));
            List<GoodsType> goodsTypes = mongoTemplate.find(query, GoodsType.class);
            Update update = Update.update("typeName", request.getTypeName());
            mongoTemplate.updateFirst(query, update, GoodsType.class);
        }
    }

    private static void buildEntity(AddModifyGoodsTypeReq request, GoodsType goodsType) {
        Date now = new Date();
        goodsType.setId(SNOWFLAKE_ID_GENERATOR.nextId());
        goodsType.setTypeName(request.getTypeName());
        goodsType.setCreateTime(now);
        goodsType.setUpdateTime(now);
        goodsType.setLogicDelete(false);
        goodsType.setCreateUserId(-1L);
        goodsType.setUpdateUserId(-1L);
    }

}
