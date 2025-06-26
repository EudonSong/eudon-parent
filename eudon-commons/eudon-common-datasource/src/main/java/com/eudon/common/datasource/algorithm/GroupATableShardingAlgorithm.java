package com.eudon.common.datasource.algorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 字段A分片算法 - 用于表分片
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/1/27
 */
public class GroupATableShardingAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties props = new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        // 根据分片键的值进行表分片
        String value = shardingValue.getValue();
        if (value == null) {
            return availableTargetNames.iterator().next();
        }
        
        // 使用哈希算法进行分片，计算表分片索引 (0-3)
        int hash = Math.abs(value.hashCode());
        int tableIndex = (hash % 4) + 1; // 生成 1-4 的表分片索引
        
        // 从可用目标名称中找到对应的表分片
        String tableSuffix = String.format("%04d", tableIndex); // 0001, 0002, 0003, 0004
        
        for (String targetName : availableTargetNames) {
            if (targetName.endsWith("_" + tableSuffix)) {
                return targetName;
            }
        }
        
        // 如果没找到，返回第一个可用目标
        return availableTargetNames.iterator().next();
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        // 范围查询时返回所有可用目标
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