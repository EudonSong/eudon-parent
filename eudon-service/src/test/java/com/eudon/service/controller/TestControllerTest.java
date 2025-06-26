package com.eudon.service.controller;

import com.eudon.service.domain.entity.TbUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class TestControllerTest {

    @Test
    public void test(){
        TbUserEntity mock = Mockito.mock(TbUserEntity.class);
        log.debug(mock.toString());
    }
}