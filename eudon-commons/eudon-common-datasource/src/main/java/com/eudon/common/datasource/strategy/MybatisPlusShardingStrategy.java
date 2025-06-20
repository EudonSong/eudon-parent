package com.eudon.common.datasource.strategy;

import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description MyBatis-Plus 轻量级分片策略
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/1/27
 */
@Component
public class MybatisPlusShardingStrategy implements TableNameHandler {

    private static final Map<String, String> TABLE_MAPPING = new ConcurrentHashMap<>();

    static {
        // 初始化表名映射
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 4; j++) {
                String suffix = String.format("%04d", j);
                TABLE_MAPPING.put("table_" + i + "_" + suffix, "table_" + i + "_" + suffix);
            }
        }
    }

    @Override
    public String dynamicTableName(String sql, String tableName) {
        // 根据上下文或参数动态确定表名
        // 这里可以根据 ThreadLocal 或其他方式获取分片信息
        return tableName;
    }

    /**
     * 根据字段A进行分片
     */
    public static String getTableNameByFieldA(String baseTableName, String fieldAValue) {
        if (fieldAValue == null) {
            return baseTableName + "_0001";
        }
        int hash = Math.abs(fieldAValue.hashCode());
        int index = (hash % 4) + 1;
        return baseTableName + "_" + String.format("%04d", index);
    }

    /**
     * 根据字段B进行分片
     */
    public static String getTableNameByFieldB(String baseTableName, String fieldBValue) {
        if (fieldBValue == null) {
            return baseTableName + "_0001";
        }
        int hash = Math.abs(fieldBValue.hashCode());
        int index = (hash % 4) + 1;
        return baseTableName + "_" + String.format("%04d", index);
    }

    /**
     * 获取数据库名称
     */
    public static String getDatabaseName(String fieldValue) {
        if (fieldValue == null) {
            return "ds0";
        }
        int hash = Math.abs(fieldValue.hashCode());
        return "ds" + (hash % 2);
    }
} 