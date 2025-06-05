package com.eudon.common.json.deserializer;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.Date;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description 日期时间字段反序列化器，如果新增自定义格式，扩充patterns
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/5
 */
public class DateDeserializer extends JsonDeserializer<Date> {
    private final String[] patterns = {"yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss", "yyyyMMdd", "yyyyMM", "yyyyMMdd-HHmmss"
            , "yyyy/MM/dd-HH:mm:ss", "yyyy-MM-dd HH:mm:ss"};

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String source = jsonParser.getText();
        if (StringUtils.isNotBlank(source)) {
            return DateUtil.parse(source.trim(), patterns);
        }
        return null;
    }
}
