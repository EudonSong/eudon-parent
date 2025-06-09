package com.eudon.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 启动类
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/06/04
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.eudon"})
@MapperScan(basePackages = {"com.eudon.service.dao"})
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class, args);
    }
}
