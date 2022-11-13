package com.jy.stock.pojo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liaojunyao
 */
@Data
public class PageRequest {

    @ApiModelProperty("当前页")
    protected Integer pageNo;

    @ApiModelProperty("页大小")
    protected Integer pageSize;

}
