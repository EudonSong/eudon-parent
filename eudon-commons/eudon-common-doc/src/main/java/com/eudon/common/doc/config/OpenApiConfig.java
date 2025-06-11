package com.eudon.common.doc.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description Swagger配置类
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/11
 */
@Configuration
public class OpenApiConfig {
    @Value("${spring.application.name}")
    private String appName;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info()
                .title(appName.concat(" API Documentation"))
                .version("1.0.0")
                .description(appName.concat("项目接口文档"))
                .contact(new Contact()
                        .name("eudon")
                        .email("syd19970616@gmail.com")
                        .url("https://gitee.com/eudon")));
    }
}
