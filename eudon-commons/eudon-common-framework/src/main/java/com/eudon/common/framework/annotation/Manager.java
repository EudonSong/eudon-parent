package com.eudon.common.framework.annotation;


import org.springframework.core.annotation.AliasFor;
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
@Component
@Target({ElementType.TYPE})
@Inherited
public @interface Manager {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
