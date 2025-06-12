package com.eudon.service.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eudon.service.domain.entity.TbUserEntity;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 针对tb_user的数据库操作
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public interface TbUserMapper extends BaseMapper<TbUserEntity> {

    int deleteByPrimaryKey(Long id);

    int insert(TbUserEntity record);

    int insertSelective(TbUserEntity record);

    TbUserEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserEntity record);

    int updateByPrimaryKey(TbUserEntity record);

}
