package com.jy.stock.common.enhance;

import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.util.StreamUtils;
import com.jy.stock.common.util.bean.BeanCopyUtils;
import com.jy.stock.pojo.dto.PageDTO;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author liaojunyao
 */
public abstract class EnhancedController<VO, DTO> {

    protected Log log = LogFactory.getLog(getClass());

    protected VO toVo(DTO dto) {
        Class<?> voClass = getVoClass();
        try {
            ReflectionUtils.makeAccessible(voClass.getConstructors()[0]);
            VO o = (VO) voClass.getConstructors()[0].newInstance();
            BeanCopyUtils.copy(dto, o);
            return o;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.error("Generate new instance error, type: " + voClass.getName(), e);
            return null;
        }
    }

    protected PageVO<VO> toPageVO(PageDTO<DTO> page){
        PageVO<VO> dto = new PageVO<>();
        dto.setPageNo(page.getPageNo());
        dto.setPageSize(page.getPageSize());
        dto.setPages(page.getPages());
        dto.setTotal(page.getTotal());
        dto.setList(StreamUtils.mapCollect(page.getList(), this::toVo));
        return dto;
    }

    public abstract Class<VO> getVoClass();

}
