package com.jy.stock.pojo.request.user;

import com.jy.stock.common.validate.annotation.user.ValidateConfirmPassword;
import com.jy.stock.common.validate.annotation.user.ValidateUserRole;
import com.jy.stock.common.validate.group.InsertAction;
import com.jy.stock.common.validate.group.UpdateAction;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 新增修改用户请求
 * @author liaojunyao
 */
@Data
@ValidateConfirmPassword(groups = {InsertAction.class, UpdateAction.class})
public class AddModifyUserInfoReq {

    @NotNull(groups = UpdateAction.class, message = "{id.can.not.null}")
    @Min(value = 1, groups = UpdateAction.class, message = "{id.invalid}")
    private Long id;

    @NotBlank(groups = InsertAction.class, message = "{user.name.can.not.empty}")
    private String userName;

    @NotBlank(groups = {InsertAction.class}, message = "{password.can.not.empty}")
    private String password;

    @NotBlank(groups = {InsertAction.class}, message = "{confirm.password.can.not.empty}")
    private String confirmPassword;

    private String avatarUrl;

    private String memo;

    @NotEmpty(groups = {InsertAction.class}, message = "{roles.can.not.empty}")
    @ValidateUserRole(groups = {InsertAction.class, UpdateAction.class})
    private List<String> roles;

}
