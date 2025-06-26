package com.eudon.service.manager;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eudon.common.framework.annotation.Manager;
import com.eudon.service.dao.TbUserMapper;
import com.eudon.service.domain.entity.TbUserEntity;
import lombok.extern.slf4j.Slf4j;

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

    private final TbUserMapper tbUserMapper;

    public TestManager(TbUserMapper tbUserMapper) {
        this.tbUserMapper = tbUserMapper;
    }

    public void test() {
        TbUserEntity tbUserEntity = new TbUserEntity();
        tbUserEntity.setZoneVal(122L);
        QueryWrapper<TbUserEntity> wrapper = new QueryWrapper<>();
        wrapper.setEntity(tbUserEntity);
        TbUserEntity one = tbUserMapper.selectOne(wrapper);
        log.debug("查询结果：{}",one);
    }
}
