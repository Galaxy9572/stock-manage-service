package com.jy.stock.controller.user;

import com.jy.stock.common.enhance.EnhancedController;
import com.jy.stock.common.response.PageVO;
import com.jy.stock.common.response.ResponseVO;
import com.jy.stock.common.validate.group.InsertAction;
import com.jy.stock.common.validate.group.UpdateAction;
import com.jy.stock.pojo.dto.PageDTO;
import com.jy.stock.pojo.dto.user.UserInfoDTO;
import com.jy.stock.pojo.request.user.AddModifyUserInfoReq;
import com.jy.stock.pojo.request.user.QueryUserInfoReq;
import com.jy.stock.pojo.request.user.UserLoginReq;
import com.jy.stock.pojo.response.user.UserInfoVO;
import com.jy.stock.service.user.UserInfoService;
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
@RequestMapping("/user/info")
public class UserInfoController extends EnhancedController<UserInfoVO, UserInfoDTO> {

    @Resource
    private UserInfoService userInfoService;

    @PutMapping("")
    public ResponseVO<UserInfoVO> addUserInfo(@RequestBody @Validated({InsertAction.class}) AddModifyUserInfoReq request) {
        UserInfoDTO userInfoDTO = userInfoService.addUser(request);
        UserInfoVO userInfoVO = toVo(userInfoDTO);
        return ResponseVO.success(userInfoVO);
    }

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
