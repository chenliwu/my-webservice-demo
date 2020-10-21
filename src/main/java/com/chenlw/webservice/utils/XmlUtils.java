package com.chenlw.webservice.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;
import com.fasterxml.jackson.dataformat.xml.util.XmlRootNameLookup;

import java.io.IOException;

/**
 * bean转xml工具类
 *
 * @author zhoul
 */
public class XmlUtils {

    private XmlUtils() {
    }

    private static final XmlMapper XML_MAPPER = new XmlMapper();

    private static final XmlMapper XML_MAPPER1 = new XmlMapper();

    private static final XmlSerializerProvider XML_SERIALIZER_PROVIDER = new XmlSerializerProvider(new XmlRootNameLookup());

    static {
        XML_SERIALIZER_PROVIDER.setNullValueSerializer(new NullSerializer());
        XML_MAPPER1.setSerializerProvider(XML_SERIALIZER_PROVIDER);
        // 序列化时加上文件头信息
        XML_MAPPER.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
    }

    static class NullSerializer extends JsonSerializer<Object> {
        @Override
        public void serialize(Object value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
            jsonGenerator.writeString("");
        }
    }

    /**
     * 对象转xml
     *
     * @param object 对象
     * @return xml
     */
    public static String asString(Object object) {
        try {
            return XML_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 对象转xml
     * 设置扩展空元素，即&lt;test/&gt;为&lt;test&gt;&lt;/test&gt;
     *
     * @param object 对象
     * @return xml
     */
    public static String asStringExpandEmptyElements(Object object) {
        try {
            return XML_MAPPER1.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * xml转对象
     *
     * @param xml    xml
     * @param tClass 转换的类
     * @param <T>    转换的类类型
     * @return 对象
     */
    public static <T> T xmlToBean(String xml, Class<T> tClass) {

        try {
            return XML_MAPPER.readValue(xml, tClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
