package com.eudon.common.core.annotation;


import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description manager层bean注入注解;
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/12
 */
@Retention(RetentionPolicy.RUNTIME)
@Component(value = "")
@Target({ElementType.TYPE})
@Inherited
public @interface Manager {
    String value() default "";
}
