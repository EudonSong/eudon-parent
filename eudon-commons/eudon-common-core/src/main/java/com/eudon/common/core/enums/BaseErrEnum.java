package com.eudon.common.core.enums;


/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 错误代码枚举顶层接口
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
public interface BaseErrEnum extends BaseEnum {
    String getLevel();

    enum Level {
        BUSINESS_ERROR,
        SYSTEM_ERROR,
    }
}
