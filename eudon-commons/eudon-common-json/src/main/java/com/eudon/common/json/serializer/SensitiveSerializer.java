package com.eudon.common.json.serializer;

import com.eudon.common.json.annotation.Sensitive;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 脱敏字段专用的序列化器
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public class SensitiveSerializer extends JsonSerializer<String> implements ContextualSerializer {
    //脱敏注解
    private Sensitive sensitive;

    @Override
    public void serialize(String source, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (StringUtils.isNoneBlank(source)) {
            String encrypt = sensitive.type().getRule().apply(source);
            jsonGenerator.writeString(encrypt);
            return;
        }
        jsonGenerator.writeString(source);
    }

    /**
     * 回调函数获得正确的序列化器
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            if (String.class.equals(beanProperty.getType().getRawClass())) {
                Sensitive sensitive = beanProperty.getAnnotation(Sensitive.class);
                if (sensitive != null) {
                    this.sensitive = sensitive;
                    return this;
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }
}
