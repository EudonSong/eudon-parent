package com.eudon.service.domain.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eudon.common.core.enums.Gender;
import lombok.Data;

import java.io.Serializable;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description tb_user JavaBean
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/11
 */
@Data
@TableName("tb_user")
public class TbUserEntity implements Serializable {
    /**
     *
     */
    @TableId
    private String userId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private Gender gender;

    /**
     *
     */
    private Long zoneVal;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}
