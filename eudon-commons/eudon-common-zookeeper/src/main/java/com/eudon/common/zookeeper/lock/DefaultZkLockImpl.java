package com.eudon.common.zookeeper.lock;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.LockInternalsDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description zookeeper分布式锁默认实现
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/30
 */
public class DefaultZkLockImpl implements ZkLock {

    @Override
    public InterProcessMutex getLock(CuratorFramework client, String path) {
        return new InterProcessMutex(client, path);
    }

    @Override
    public InterProcessMutex getLock(CuratorFramework client, String path, LockInternalsDriver driver) {
        return new InterProcessMutex(client, path, driver);
    }

    @Override
    public void acquire(InterProcessMutex lock) throws Exception {
        lock.acquire();
    }

    @Override
    public boolean acquire(InterProcessMutex lock, long time, TimeUnit unit) throws Exception {
        return lock.acquire(time, unit);
    }

    @Override
    public void release(InterProcessMutex lock) throws Exception {
        lock.release();
    }
}
