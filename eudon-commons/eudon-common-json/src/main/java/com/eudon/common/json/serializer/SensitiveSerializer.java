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

    private Sensitive.Type type;
    private String rule;

    public SensitiveSerializer() {
    }

    public SensitiveSerializer(final Sensitive sensitive) {
        this.type = sensitive.type();
        this.rule = sensitive.type().getRule().toString();
    }

    @Override
    public void serialize(final String source, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider) throws IOException {
        if (StringUtils.isNoneBlank(source) && type != null) {
            String encrypt = type.getRule().apply(source);
            jsonGenerator.writeString(encrypt);
            return;
        }
        jsonGenerator.writeString(source);
    }

    /**
     * 回调函数获得正确的序列化器
     */
    @Override
    public JsonSerializer<?> createContextual(final SerializerProvider serializerProvider, final BeanProperty beanProperty) throws JsonMappingException {
        if (beanProperty != null) {
            if (String.class.equals(beanProperty.getType().getRawClass())) {
                Sensitive sensitive = beanProperty.getAnnotation(Sensitive.class);
                if (sensitive != null) {
                    return new SensitiveSerializer(sensitive);
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }
}
