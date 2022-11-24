package com.jy.stock.pojo.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author liaojunyao
 */
@Data
public class PageRequest {

    @ApiModelProperty("当前页")
    @Min(value = 1, message = "{page.param.invalid}")
    protected Integer pageNo;

    @ApiModelProperty("页大小")
    @Min(value = 1, message = "{page.param.invalid}")
    protected Integer pageSize;

}
