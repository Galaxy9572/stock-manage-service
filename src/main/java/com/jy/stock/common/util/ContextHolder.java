package com.jy.stock.common.util;

import com.jy.stock.constants.user.UserConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 上下文获取工具
 * @author JY
 */
@Slf4j
public class ContextHolder {

    /** 用户登录注册后的session key */
    public static final String USER_SESSION_KEY = "user_session";

    /**
     * 获取当前 HttpServletRequest
     * @return HttpServletRequest
     */
    public static HttpServletRequest currentHttpRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null){
            return null;
        }
        return requestAttributes.getRequest();
    }

    public static Long currentUserId() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        AssertUtils.isNotNull(requestAttributes, "get.login.info.failed");
        HttpServletRequest request = requestAttributes.getRequest();
        Object userIdObj = request.getSession().getAttribute(UserConstants.USER_ID);
        return Long.parseLong(userIdObj.toString());
    }

}
