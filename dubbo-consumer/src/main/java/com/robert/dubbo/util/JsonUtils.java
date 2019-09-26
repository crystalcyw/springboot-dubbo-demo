package com.robert.dubbo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;


/**
 * @author changyuwei
 * @date 2019-09-11
 */
public final class JsonUtils {

    private JsonUtils(){}

    @Resource
    private static ObjectMapper mapper = new ObjectMapper();

//    static {
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        DeserializationConfig config = new DeserializationConfig();
//        DeserializationConfig with = config.with(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        mapper.setConfig(config);
//    }

    public static String toString(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode parseNode(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return mapper.readTree(json);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseBean(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T parseBean(String json, TypeReference valueTypeRef) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        try {
            return mapper.readValue(json, valueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toBean(Object object, Class<T> clazz) {
        if (object == null) {
            return null;
        }
        try {
            return mapper.convertValue(object, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T toBean(Object object, TypeReference valueTypeRef) {
        if (object == null) {
            return null;
        }
        try {
            return mapper.convertValue(object, valueTypeRef);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
