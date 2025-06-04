package com.eudon.common.core.constants;


/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 核心常量类
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
public abstract class CommonConstants {

    private CommonConstants() {
    }

    /**
     * 升序
     */
    public static final String SORT_ORDER_ASC = "ascend";

    /**
     * 降序
     */
    public static final String SORT_ORDER_DESC = "descend";

    /**
     * 错误码等级：系统级别
     */
    public static final String SYSTEM_LEVEL = "system";

    /**
     * 错误码等级：用户级别
     */
    public static final String USER_LEVEL = "user";

    /**
     * 错误码等级：未被预测到的级别
     */
    public static final String UNEXPECTED_LEVEL = "unexpected";

    /**
     * 开启分页
     */
    public static final String ENABLE_PAGINATION = "1";

    /**
     * 不开启分页
     */
    public static final String DISABLE_PAGINATION = "0";

    /**
     * 异步线程池命名
     */
    public static final String ASYNC_EXECUTOR_NAME = "eudon_async_executor";

    /**
     * cpu密集型的核心
     */
    public static final Integer CPU_CORES = Runtime.getRuntime().availableProcessors();

    /**
     * IO密集型采用的线程数量
     * 自行调整
     */
    public static final Integer IO_THREADS = 16;

    /**
     * 异步线程池默认线程数 -> 1 or processors
     */
    public static final Integer ASYNC_EXECUTOR_THREADS = Math.max(1, CPU_CORES);
}

