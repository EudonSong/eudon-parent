package com.eudon.common.core.enums;


import lombok.Getter;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 性别枚举
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/11
 */
@Getter
public enum Gender implements BaseEnum {

    MALE("1","男","男性"),
    FEMALE("0","女","女性");
    private final String code;
    private final String value;
    private final String desc;

    Gender(String code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }
}
