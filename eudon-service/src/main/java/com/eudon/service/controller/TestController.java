package com.eudon.service.controller;


import com.eudon.service.TemplateApplication;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

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
    @PostConstruct
    public void init() {
        User mock = Mockito.mock(User.class);
        log.debug(mock.toString());
    }
    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public String test(){
        return "test success";
    }

    @Data
    @ToString
    private static class User {
        private String name;
        private int age;
    }
}
