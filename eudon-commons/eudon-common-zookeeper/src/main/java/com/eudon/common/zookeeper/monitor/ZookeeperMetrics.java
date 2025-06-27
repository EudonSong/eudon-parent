package com.eudon.common.zookeeper.monitor;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.stereotype.Component;
/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description zookeeper度量组件
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/27
 */
@Component
public class ZookeeperMetrics implements MeterBinder {

    private final CuratorFramework client;

    public ZookeeperMetrics(CuratorFramework client) {
        this.client = client;
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        Gauge.builder("zookeeper.connection.status", () -> 
            client.getZookeeperClient().isConnected() ? 1 : 0)
            .description("Zookeeper connection status (1=connected, 0=disconnected)")
            .register(registry);

        Gauge.builder("zookeeper.nodes.count", () -> {
            try {
                return client.getChildren().forPath("/").size();
            } catch (Exception e) {
                return -1;
            }
        }).description("Number of nodes in Zookeeper root path")
          .register(registry);
    }
}
