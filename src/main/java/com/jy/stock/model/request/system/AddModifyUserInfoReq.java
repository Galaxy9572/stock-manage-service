package com.jy.stock.model.request.system;

import com.jy.stock.common.validate.annotation.system.ValidateConfirmPassword;
import com.jy.stock.common.validate.annotation.system.ValidateUserRole;
import com.jy.stock.common.validate.group.InsertAction;
import com.jy.stock.common.validate.group.UpdateAction;
import com.jy.stock.model.request.AddModifyRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 新增修改用户请求
 * @author liaojunyao
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ValidateConfirmPassword(groups = {InsertAction.class, UpdateAction.class})
public class AddModifyUserInfoReq extends AddModifyRequest {

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
