package com.jy.stock.common.util;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.pojo.dto.PageDTO;

/**
 * 分页工具
 * @author JY
 */
public class PageUtils {

    public static <T, VO> PageVO<VO> of(Page<T> list, Class<VO> voClas) {
        PageVO<VO> pageInfo = new PageVO<>();
        pageInfo.setPageNo((int) list.getCurrent());
        pageInfo.setPageSize((int) list.getSize());
        pageInfo.setTotal(list.getTotal());
        pageInfo.setPages((int) list.getPages());
        return pageInfo;
    }

    public static <T> PageVO<T> of(PageDTO<T> page){
        PageVO<T> vo = new PageVO<>();
        vo.setPageNo(page.getPageNo());
        vo.setPageSize(page.getPageSize());
        vo.setPages(page.getPages());
        vo.setTotal(page.getTotal());
        vo.setList(page.getList());
        return vo;
    }

}
