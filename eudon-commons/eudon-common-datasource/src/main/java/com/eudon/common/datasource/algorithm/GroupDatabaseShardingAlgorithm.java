package com.eudon.common.datasource.algorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 数据库分片算法 - 用于2个数据库
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/1/27
 */
public class GroupDatabaseShardingAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties props = new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        // 根据分片键的值进行数据库分片
        String value = shardingValue.getValue();
        if (value == null) {
            return availableTargetNames.iterator().next();
        }
        
        // 使用哈希算法进行数据库分片，计算数据库索引 (0-1)
        int hash = Math.abs(value.hashCode());
        int dbIndex = hash % 2; // 生成 0-1 的数据库索引
        
        // 从可用目标名称中找到对应的数据库
        String dbSuffix = String.valueOf(dbIndex); // 0, 1
        
        for (String targetName : availableTargetNames) {
            if (targetName.endsWith("db" + dbSuffix)) {
                return targetName;
            }
        }
        
        // 如果没找到，返回第一个可用目标
        return availableTargetNames.iterator().next();
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        // 范围查询时返回所有可用数据库
        return availableTargetNames;
    }
    
    @Override
    public void init(Properties props) {
        this.props = props;
    }

    @Override
    public Properties getProps() {
        return this.props;
    }
}