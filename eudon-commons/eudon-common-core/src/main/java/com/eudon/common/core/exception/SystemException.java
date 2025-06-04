package com.eudon.common.core.exception;


import lombok.Getter;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description TODO 系统级别的异常，可以提前预测到的非业务异常或者无法预测到的异常，后续统一处理统一报错
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
@Getter
public class SystemException extends Exception {
    private static final long serialVersionUID = 3744715741337785405L;
}
