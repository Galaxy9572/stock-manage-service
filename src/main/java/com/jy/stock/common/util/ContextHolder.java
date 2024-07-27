package com.jy.stock.common.util;

import com.jy.stock.constants.system.UserConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 上下文获取工具
 * @author JY
 */
@Slf4j
public class ContextHolder {

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
        if (requestAttributes == null){
            return null;
        }
        HttpServletRequest request = requestAttributes.getRequest();
        Object userIdObj = request.getSession().getAttribute(UserConstants.USER_ID);
        return userIdObj == null ? null : Long.parseLong(userIdObj.toString());
    }

}
