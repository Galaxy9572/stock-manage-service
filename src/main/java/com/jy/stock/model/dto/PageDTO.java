package com.jy.stock.model.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 分页结果VO
 * @author JY
 */
@Data
public class PageDTO<T> {

    /** 总页数 */
    private Integer pages;

    /** 当前页 */
    private Integer pageNo;

    /** 页大小 */
    private Integer pageSize;

    /** 总数 */
    private Long total;

    /** 数据 */
    private List<T> list;

    public static <T> PageDTO<T> of(Page<T> page){
        PageDTO<T> vo = new PageDTO<>();
        vo.setPageNo((int) page.getCurrent());
        vo.setPageSize((int) page.getSize());
        vo.setPages((int) page.getPages());
        vo.setTotal(page.getTotal());
        vo.setList(page.getRecords());
        return vo;
    }

}
