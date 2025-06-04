package com.eudon.common.core.exception;


import cn.hutool.core.util.StrUtil;
import lombok.Getter;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 业务异常，业务相关的报错必须采用此异常，进行异常统一拦截处理
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
@Getter
public class BusinessException extends Exception {
    private static final long serialVersionUID = -6513946951407374163L;
    private final String errCode;
    private final String errMsg;

    public BusinessException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BusinessException(String errCode, String template, String... params) {
        this.errCode = errCode;
        if (StrUtil.isBlank(template) || params == null || params.length == 0) {
            this.errMsg = template;
        } else {
            this.errMsg = String.format(template, new Object[]{params});
        }
    }

}
