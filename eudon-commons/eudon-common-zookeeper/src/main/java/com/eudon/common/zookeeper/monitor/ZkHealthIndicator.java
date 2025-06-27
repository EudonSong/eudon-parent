package com.eudon.common.zookeeper.monitor;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.zookeeper.ZookeeperHealthIndicator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description zookeeper健康指示器
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/27
 */
@Component  // 不指定名称，让Spring使用类名首字母小写
@ConditionalOnMissingBean(ZookeeperHealthIndicator.class)
public class ZkHealthIndicator implements HealthIndicator {
    
    private final CuratorFramework client;

    public ZkHealthIndicator(CuratorFramework client) {
        this.client = client;
    }

    @Override
    public Health health() {
        Health health = null;
        try {
            if (client.getZookeeperClient().isConnected()) {
                health = Health.up()
                        .withDetail("connection", "connected")
                        .withDetail("nodes", client.getChildren().forPath("/").size())
                        .build();
                return health;
            }
            health = Health.down().withDetail("connection", "disconnected").build();
            return health;
        } catch (Exception e) {
            health = Health.outOfService()
                .withException(e)
                .withDetail("error", e.getMessage())
                .build();
            return health;
        }
    }
}
