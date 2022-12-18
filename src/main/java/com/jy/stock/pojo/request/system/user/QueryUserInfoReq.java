package com.jy.stock.pojo.request.system.user;

import com.jy.stock.pojo.request.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author liaojunyao
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QueryUserInfoReq extends PageRequest {

    private String userName;

    private List<String> roles;

}
