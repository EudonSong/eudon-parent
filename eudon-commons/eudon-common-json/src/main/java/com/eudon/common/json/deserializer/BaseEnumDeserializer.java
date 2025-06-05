package com.eudon.common.json.deserializer;

import com.eudon.common.core.enums.BaseEnum;
import com.eudon.common.core.utils.EnumUtil;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 枚举字段反序列化器 TODO 待测试
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public class BaseEnumDeserializer<T extends BaseEnum> extends JsonDeserializer<BaseEnum> {
    private final Class<T> enumClass;

    public BaseEnumDeserializer(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String source = jsonParser.getText();
        if (StringUtils.isNotBlank(source)) {
            T aEnum = EnumUtil.getEnumByCode(source,enumClass);
            if (aEnum == null) {
                return EnumUtil.getEnumByValue(source, enumClass);
            }
            return aEnum;
        }
        return null;
    }
}
