package com.eudon.service.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 测试控制器
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
@Slf4j
@RestController
public class TestController {
    @Value("${test1.import}")
    private String test1;
    @Value("${test2.import}")
    private String test2;
    @PostConstruct
    public void init() {
        log.debug("test1: {}", test1);
        log.debug("test2: {}", test2);
    }
    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public String test(){

        return "test success";
    }
}
