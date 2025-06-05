package com.eudon.common.json.serializer;

import com.eudon.common.core.enums.BaseEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 自定义注解的序列化器, 如果对应枚举的值是null，则不执行此序列化规则，若想自定义null值枚举的序列化规则，
 *  * 只需要继承此类，重写一下serialize方法，然后在需要处理的字段上添加 ’nullusing = 自定义序列化器‘ 即可
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public class BaseEnumSerializer extends JsonSerializer<BaseEnum> {
    @Override
    public void serialize(BaseEnum baseEnum, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(baseEnum.getValue());
    }
}
