package com.jy.stock.model.request;

import jakarta.validation.constraints.Min;
import lombok.Data;


/**
 * @author liaojunyao
 */
@Data
public class PageRequest {

    @Min(value = 1, message = "{page.param.invalid}")
    protected Integer pageNo;

    @Min(value = 1, message = "{page.param.invalid}")
    protected Integer pageSize;

}
