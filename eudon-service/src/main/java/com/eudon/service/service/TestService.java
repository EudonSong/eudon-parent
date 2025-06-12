package com.eudon.service.service;


import com.eudon.service.manager.TestManager;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 示例
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/12
 */
@Slf4j
@Service
public class TestService {
    @Resource
    private TestManager testManager;

    public void test() {
        testManager.test();
    }
}
