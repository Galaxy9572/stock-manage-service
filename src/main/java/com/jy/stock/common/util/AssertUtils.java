package com.jy.stock.common.util;

import com.jy.stock.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.Objects;

/**
 * 断言工具类
 *
 * @author JY
 */
public class AssertUtils {

    /**
     * 断言对象为空，否则抛出业务异常
     *
     * @param object   对象
     * @param i18nCode 错误信息编码
     */
    public static void isNull(Object object, String i18nCode) {
        if (object != null) {
            throw BusinessException.of(i18nCode);
        }
    }

    /**
     * 断言对象不为空，否则抛出业务异常
     *
     * @param object   对象
     * @param i18nCode 错误信息编码
     */
    public static void isNotNull(Object object, String i18nCode) {
        if (object == null) {
            throw BusinessException.of(i18nCode);
        }
    }

    /**
     * 断言两个字符串相等，否则抛出业务异常
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @param i18nCode 错误信息编码
     */
    public static void equal(String s1, String s2, String i18nCode) {
        if (!StringUtils.equals(s1, s2)) {
            throw BusinessException.of(i18nCode);
        }
    }

    /**
     * 断言两个对象相等，否则抛出业务异常
     *
     * @param o1 对象1
     * @param o2 对象2
     * @param i18nCode 错误信息编码
     */
    public static void equal(Object o1, Object o2, String i18nCode) {
        if (!Objects.equals(o1, o2)) {
            throw BusinessException.of(i18nCode);
        }
    }

    /**
     * 断言为true，否则抛出业务异常
     * @param bool 布尔值
     * @param i18nCode 错误信息编码
     */
    public static void isTrue(boolean bool, String i18nCode){
        if (!bool) {
            throw BusinessException.of(i18nCode);
        }
    }

    /**
     * 断言为true，否则抛出业务异常
     * @param bool 布尔值
     * @param httpStatus HttpStatus
     * @param i18nCode 错误信息编码
     */
    public static void isTrue(boolean bool, HttpStatus httpStatus, String i18nCode){
        if (!bool) {
            throw BusinessException.of(httpStatus, i18nCode);
        }
    }

    /**
     * 断言为true，否则抛出业务异常
     * @param bool 布尔值
     * @param i18nCode 错误信息编码
     */
    public static void isFalse(boolean bool, String i18nCode){
        if (bool) {
            throw BusinessException.of(i18nCode);
        }
    }

}
