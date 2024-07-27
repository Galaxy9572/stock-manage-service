package com.jy.stock.common.response;

import com.jy.stock.common.util.SpringBeanUtil;
import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

/**
 * 返回结果类
 * @author JY
 */
@Data
public class HttpResult<T> {

    /** 状态码 */
    private Integer code;

    /** 提示消息 */
    private String message;

    /** 返回数据 */
    private T data;

    public static <T> HttpResult<T> success(String i18nCode){
        MessageSource messageSource = SpringBeanUtil.getBean(MessageSource.class);
        String i18nMessage = messageSource.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        return HttpResult.build(HttpStatus.OK.value(), i18nMessage, null);
    }

    public static <T> HttpResult<T> success(T data){
        return HttpResult.build(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
    }

    public static <T> HttpResult<T> success(){
        return HttpResult.build(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }

    public static <T> HttpResult<T> success(HttpStatus status, T data){
        return HttpResult.build(status.value(), status.getReasonPhrase(), data);
    }

    public static <T> HttpResult<T> success(String message, T data){
        return HttpResult.build(HttpStatus.OK.value(), message, data);
    }

    public static <T> HttpResult<T> failed(HttpStatus status, String message){
        return HttpResult.build(status.value(), message, null);
    }

    public static <T> HttpResult<T> failed(String i18nCode){
        MessageSource messageSource = SpringBeanUtil.getBean(MessageSource.class);
        String i18nMessage = messageSource.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        return HttpResult.build(HttpStatus.EXPECTATION_FAILED.value(), i18nMessage, null);
    }

    public static <T> HttpResult<T> failed(HttpStatus status, String i18nCode, Object... params){
        MessageSource messageSource = SpringBeanUtil.getBean(MessageSource.class);
        String i18nMessage = messageSource.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        String message = MessageFormat.format(i18nMessage, params);
        return HttpResult.build(status.value(), message, null);
    }

    public static <T> HttpResult<T> failed(HttpStatus status){
        return HttpResult.build(status.value(), status.getReasonPhrase(), null);
    }

    private static <T> HttpResult<T> build(Integer code, String message, T data) {
        HttpResult<T> httpResult = new HttpResult<>();
        httpResult.setCode(code);
        httpResult.setMessage(message);
        httpResult.setData(data);
        return httpResult;
    }

}
