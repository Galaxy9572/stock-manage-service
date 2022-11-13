package com.jy.stock.common.exception;

import com.maimai.miwuyou.user.common.util.SpringBeanUtil;
import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

/**
 * @author JY
 */
public class BusinessException extends RuntimeException{

    private static final MessageSource MESSAGE_SOURCE = SpringBeanUtil.getBean(MessageSource.class);

    @Getter
    private final HttpStatus httpStatus;

    public BusinessException(String message) {
        super(message);
        this.httpStatus = HttpStatus.EXPECTATION_FAILED;
    }

    public BusinessException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public static BusinessException msg(String msg) {
        return new BusinessException(msg);
    }

    public static BusinessException of(String i18nCode) {
        String i18nMessage = MESSAGE_SOURCE.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        return new BusinessException(i18nMessage);
    }

    public static BusinessException format(String i18nCode, String msg) {
        String i18nMessage = MESSAGE_SOURCE.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        return new BusinessException(MessageFormat.format(i18nMessage, msg));
    }

    public static BusinessException of(HttpStatus httpStatus, String i18nCode) {
        String i18nMessage = MESSAGE_SOURCE.getMessage(i18nCode, null, LocaleContextHolder.getLocale());
        return new BusinessException(httpStatus, i18nMessage);
    }

}
