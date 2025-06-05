package com.eudon.common.json.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 脱敏工具类
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public class SensitiveUtil {
    /**
     * 密码，全部加密
     */
    public static String encryptPassword(String source) {
        return StringUtils.repeat("*", source.length());
    }

    /**
     * 地址，隐藏敏感信息，X作为替代字符
     */
    public static String encryptAddress(String source) {
        return source.replaceAll("[\\d一二三四五六七八九十壹贰叁肆伍陆柒捌玖拾佰]+", "XXX");
    }

    /**
     * ipv4 && ipv6，替换所有数字为x
     */
    public static String encryptIpAddress(String source) {
        return StringUtils.repeat("x", source.length());
    }

    /**
     * 银行卡号，展示前六位和后四位
     */
    public static String encryptBankCard(String source) {
        if (source.length() < 10) return StringUtils.repeat("*", source.length());
        return StringUtils.rightPad(StringUtils.left(source, 6), source.length() - 4, "*")
                .concat(source.substring(source.length() - 4));
    }

    /**
     * 手机号，展示前三位和后四位
     */
    public static String encryptMobilePhone(String source) {
        return source.replaceAll("/(\\d{3})\\d*(\\d{4})/", "$1****$2");
    }

    /**
     * 固话号,展示后四位
     */
    public static String encryptFixedPhone(String source) {
        String last4 = StringUtils.right(source, 4);
        return StringUtils.leftPad(last4, source.length(), "*");
    }

    /**
     * 邮箱，展示第一位以及邮箱归属
     */
    public static String encryptEmail(String source) {
        if (source.isEmpty()) {
            return source;
        }
        int index = source.indexOf("@");
        String prefix = StringUtils.rightPad(StringUtils.left(source, 1), index, "*");
        String substring = source.substring(index);
        return prefix.concat(substring);
    }

    /**
     * 中文名字，展示第一位和最后一位
     */
    public static String encryptCHNName(String source) {
        if (source.length() <= 1) {
            return source;
        }
        return StringUtils.rightPad(StringUtils.left(source, 1), source.length() - 1, "*")
                .concat(StringUtils.right(source, 1));
    }

    /**
     * 英文名字，展示第一位和最后一位
     */
    public static String encryptENName(String source) {
        if (source.length() <= 1) {
            return source;
        }
        if (source.length() == 2) {
            return source.substring(0, 1).concat("*");
        }
        return StringUtils.rightPad(StringUtils.left(source, 1), source.length() - 1, "*")
                .concat(StringUtils.right(source, 1));
    }

    /**
     * 身份证号,展示前六位和后四位
     */
    public static String encryptIDCard(String source) {
        return StringUtils.rightPad(StringUtils.left(source, 6), source.length() - 4, "*")
                .concat(source.substring(source.length() - 4));
    }
}
