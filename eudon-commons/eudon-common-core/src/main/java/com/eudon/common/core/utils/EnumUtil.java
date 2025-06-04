package com.eudon.common.core.utils;


import com.eudon.common.core.enums.BaseEnum;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 枚举工具类
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
public class EnumUtil {
    /**
     * 根据code获取对应枚举。
     *
     * @param code   code
     * @param tClass 指定枚举类
     * @param <T>    泛型
     * @return 指定枚举
     */
    public static <T extends BaseEnum> T getEnumByCode(String code, Class<T> tClass) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(tClass);
        return Stream.of(tClass.getEnumConstants())
                .filter(item -> item.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    /**
     * 根据value获取对应枚举。
     *
     * @param value  value
     * @param tClass 指定枚举类
     * @param <T>    泛型
     * @return 指定枚举
     */
    public static <T extends BaseEnum> T getEnumByValue(String value, Class<T> tClass) {
        Objects.requireNonNull(value);
        Objects.requireNonNull(tClass);
        return Stream.of(tClass.getEnumConstants())
                .filter(item -> item.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }
}
