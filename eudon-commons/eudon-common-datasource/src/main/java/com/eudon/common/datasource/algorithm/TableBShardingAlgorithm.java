package com.eudon.common.datasource.algorithm;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 字段B分片算法 - 用于8张表
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/1/27
 */
public class TableBShardingAlgorithm implements StandardShardingAlgorithm<String> {

    private Properties props = new Properties();

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        // 根据字段B的值进行分片
        String value = shardingValue.getValue();
        if (value == null) {
            return availableTargetNames.iterator().next();
        }
        
        // 使用取模算法进行分片，确保数据均匀分布
        int hash = Math.abs(value.hashCode());
        int index = hash % availableTargetNames.size();
        
        return availableTargetNames.toArray(new String[0])[index];
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
} 