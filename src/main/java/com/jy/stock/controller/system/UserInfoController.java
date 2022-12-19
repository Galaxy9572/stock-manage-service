package com.jy.stock.controller.system;

import com.jy.stock.common.aspect.annotation.AuthCheck;
import com.jy.stock.common.aspect.annotation.OperationLog;
import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.validate.group.InsertAction;
import com.jy.stock.common.validate.group.UpdateAction;
import com.jy.stock.enums.system.ModuleEnum;
import com.jy.stock.enums.system.OperationTypeEnum;
import com.jy.stock.enums.system.SubModuleEnum;
import com.jy.stock.enums.system.UserRoleEnum;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.system.UserInfoDTO;
import com.jy.stock.pojo.request.system.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.system.QueryUserInfoReq;
import com.jy.stock.pojo.request.system.UserLoginReq;
import com.jy.stock.pojo.response.system.UserInfoVO;
import com.jy.stock.service.system.UserInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 用户信息控制层
 *
 * @author liaojunyao
 */
@RestController
@RequestMapping("/system/user/info")
public class UserInfoController extends EnhancedController<UserInfoVO, UserInfoDTO> {

    @Resource
    private UserInfoService userInfoService;

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.SYSTEM, subModule = SubModuleEnum.USER, operationType = OperationTypeEnum.ADD)
    @PutMapping("")
    public ResponseVO<UserInfoVO> addUserInfo(@RequestBody @Validated({InsertAction.class}) AddModifyUserInfoReq request) {
        UserInfoDTO userInfoDTO = userInfoService.addUser(request);
        UserInfoVO userInfoVO = toVo(userInfoDTO);
        return ResponseVO.success(userInfoVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.SYSTEM, subModule = SubModuleEnum.USER, operationType = OperationTypeEnum.UPDATE)
    @PostMapping("")
    public ResponseVO<UserInfoVO> updateUserInfo(@RequestBody @Validated({UpdateAction.class}) AddModifyUserInfoReq request) {
        UserInfoDTO userInfoDTO = userInfoService.updateUser(request);
        UserInfoVO userInfoVO = toVo(userInfoDTO);
        return ResponseVO.success(userInfoVO);
    }

    @PostMapping("/list")
    public ResponseVO<PageVO<UserInfoVO>> listUserInfo(@RequestBody QueryUserInfoReq request) {
        PageDTO<UserInfoDTO> pageDTO = userInfoService.listUserInfoByPage(request);
        PageVO<UserInfoVO> pageVO = toPageVO(pageDTO);
        return ResponseVO.success(pageVO);
    }

    @AuthCheck(roles = UserRoleEnum.ADMIN)
    @OperationLog(module = ModuleEnum.SYSTEM, subModule = SubModuleEnum.USER, operationType = OperationTypeEnum.DELETE)
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> deleteUserInfo(@PathVariable Long id) {
        boolean isSuccess = userInfoService.deleteUser(id);
        return ResponseVO.success(isSuccess);
    }

    @PostMapping("/login")
    public ResponseVO<UserInfoVO> login(HttpSession session, @RequestBody UserLoginReq loginReq) {
        UserInfoDTO userInfo = userInfoService.login(session, loginReq);
        UserInfoVO userInfoVO = toVo(userInfo);
        return ResponseVO.success(userInfoVO);
    }

    @GetMapping("{userId}")
    public ResponseVO<UserInfoVO> getUserInfo(@PathVariable Long userId) {
        UserInfoDTO userInfo = userInfoService.getUserInfoById(userId);
        UserInfoVO userInfoVO = toVo(userInfo);
        return ResponseVO.success(userInfoVO);
    }

    @Override
    public Class<UserInfoVO> getVoClass() {
        return UserInfoVO.class;
    }

}
