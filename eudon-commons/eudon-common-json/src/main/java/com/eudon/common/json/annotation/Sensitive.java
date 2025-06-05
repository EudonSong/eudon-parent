package com.eudon.common.json.annotation;


import com.eudon.common.json.utils.SensitiveUtil;
import lombok.Getter;

import java.util.function.Function;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public @interface Sensitive {

    /*
      脱敏的数据类型
     */
    Type type();

    /**
     * 脱敏的数据类型枚举
     */
    @Getter
    enum Type {
        PASSWORD("密码", SensitiveUtil::encryptPassword),
        ADDRESS("地址", SensitiveUtil::encryptAddress),
        BANK_CARD("银行卡", SensitiveUtil::encryptBankCard),
        IP_ADDRESS("ipv4 && ipv6", SensitiveUtil::encryptIpAddress),
        MOBILE_PHONE("手机号", SensitiveUtil::encryptMobilePhone),
        FIXED_PHONE("固话号", SensitiveUtil::encryptFixedPhone),
        EMAIL("邮箱", SensitiveUtil::encryptEmail),
        ID_CARD("身份证", SensitiveUtil::encryptIDCard),
        CHN_NAME("中文名", SensitiveUtil::encryptCHNName),
        EN_NAME("英文名字", SensitiveUtil::encryptENName);

        private final String desc;
        private final Function<String, String> rule;

        Type(String desc, Function<String, String> rule) {
            this.desc = desc;
            this.rule = rule;
        }
    }
}
