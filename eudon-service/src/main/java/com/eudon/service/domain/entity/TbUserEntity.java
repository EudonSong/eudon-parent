package com.eudon.service.domain.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.eudon.common.core.enums.Gender;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

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

    private static final long serialVersionUID = 1L;
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TbUserEntity that = (TbUserEntity) o;
        return Objects.equals(userId, that.userId) && Objects.equals(userName, that.userName) && gender == that.gender && Objects.equals(zoneVal, that.zoneVal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, gender, zoneVal);
    }

    @Override
    public String toString() {
        return "TbUserEntity{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", zoneVal=" + zoneVal +
                '}';
    }
}
