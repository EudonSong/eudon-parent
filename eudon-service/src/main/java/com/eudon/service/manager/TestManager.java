package com.eudon.service.manager;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eudon.common.framework.annotation.Manager;
import com.eudon.service.dao.TbUserMapper;
import com.eudon.service.domain.entity.TbUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 示例项目
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/12
 */
@Slf4j
@Manager
public class TestManager {
    private final CuratorFramework client;
    private final TbUserMapper tbUserMapper;

    public TestManager(CuratorFramework client, TbUserMapper tbUserMapper) {
        this.client = client;
        this.tbUserMapper = tbUserMapper;
    }

    public void test() {
        TbUserEntity tbUserEntity = new TbUserEntity();
        tbUserEntity.setZoneVal(122L);
        QueryWrapper<TbUserEntity> wrapper = new QueryWrapper<>();
        wrapper.setEntity(tbUserEntity);
        TbUserEntity one = tbUserMapper.selectOne(wrapper);
        log.debug("查询结果：{}",one);

        try {
//            String s = client.create().forPath("/eudon1");
//            log.info("创建结果:{}",s);
//            client.setData().forPath("/eudon","eudon".getBytes());
//            byte[] eudonDate = client.getData().forPath("/eudon");
//            log.info("eudonData:{}",new String(eudonDate));
//            List<String> children = client.getChildren().forPath("/");
//            log.info("/的子节点:{}",children);
//            byte[] bytes = client.getData().forPath("/services/TemplateApplication");
//            log.info("/service:{}",bytes);
            CuratorZookeeperClient zookeeperClient = client.getZookeeperClient();
            ZooKeeper zooKeeper = zookeeperClient.getZooKeeper();
            client.delete().inBackground((var1,var2) -> {
                log.info("curatorFramework:{}",var1);
                log.info("curatorEvent:{}",var2);
            }).forPath("/eudon");
//            byte[] data = zooKeeper.getData("/", true, new Stat());
//            log.info("zookeeper:{}",data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
