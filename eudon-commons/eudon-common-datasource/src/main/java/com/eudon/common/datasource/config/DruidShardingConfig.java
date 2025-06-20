package com.eudon.common.datasource.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description Druid 多数据源分片配置
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/1/27
 */
@Configuration
public class DruidShardingConfig {

    // 这里可以配置多个 Druid 数据源
    // 每个数据源对应一个数据库
    // 通过 AOP 或拦截器实现分片逻辑
} 