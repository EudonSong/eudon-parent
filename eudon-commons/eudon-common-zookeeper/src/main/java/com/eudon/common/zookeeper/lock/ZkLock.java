package com.eudon.common.zookeeper.lock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.LockInternalsDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description zookeeper分布式锁接口，提供简单的获取锁释放锁方法，自定义锁逻辑实现接口
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/30
 */
public interface ZkLock {
    Logger log = LoggerFactory.getLogger(ZkLock.class);

    default InterProcessMutex getLock(CuratorFramework client){
        log.info("ZkLock默认方法实现分布式锁，CuratorFramework:{}",client);
        return new InterProcessMutex(client, "/lock");
    }

    InterProcessMutex getLock(CuratorFramework client, String path);

    InterProcessMutex getLock(CuratorFramework client, String path, LockInternalsDriver driver);

    void acquire(InterProcessMutex lock) throws Exception;

    boolean acquire(InterProcessMutex lock,long time, TimeUnit unit) throws Exception;

    void release(InterProcessMutex lock) throws Exception;
}
