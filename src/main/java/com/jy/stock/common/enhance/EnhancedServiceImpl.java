package com.jy.stock.common.enhance;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jy.stock.common.util.AssertUtils;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.model.dto.PageDTO;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @author liaojunyao
 */
public abstract class EnhancedServiceImpl<M extends BaseMapper<T>, T, DTO> extends ServiceImpl<M, T> {

    public DTO checkExistenceById(Long id, boolean assertExists) {
        T entity = getById(id);
        if (assertExists) {
            AssertUtils.isNotNull(entity, "data.not.exist");
        } else {
            AssertUtils.isNull(entity, "data.already.exist");
        }
        return entity != null ? toDto(entity) : null;
    }

    protected DTO toDto(T t) {
        Class<?> dtoClass = getDtoClass();
        try {
            ReflectionUtils.makeAccessible(dtoClass.getConstructors()[0]);
            DTO o = (DTO) dtoClass.getConstructors()[0].newInstance();
            BeanCopyUtils.copy(t, o);
            return o;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.error("Generate new instance error, type: " + dtoClass.getName(), e);
            return null;
        }
    }

    protected List<DTO> toDtoList(List<T> list) {
        return StreamUtils.mapCollect(list, this::toDto);
    }

    protected PageDTO<DTO> toPageDTO(IPage<T> page){
        PageDTO<DTO> dto = new PageDTO<>();
        dto.setPageNo((int) page.getCurrent());
        dto.setPageSize((int) page.getSize());
        dto.setPages((int) page.getPages());
        dto.setTotal(page.getTotal());
        List<DTO> dtoList = toDtoList(page.getRecords());
        dto.setList(dtoList);
        return dto;
    }

    protected LambdaQueryWrapper<T> getQueryWrapper() {
        return new LambdaQueryWrapper<>();
    }

    public abstract Class<DTO> getDtoClass();
}
