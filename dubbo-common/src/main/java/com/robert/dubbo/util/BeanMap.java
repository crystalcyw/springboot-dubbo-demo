package com.robert.dubbo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author changyuwei
 * @date 2019-09-12
 */
public class BeanMap extends HashMap<String, Object> {

    public static BeanMap instance() {
        return new BeanMap();
    }

    public static BeanMap instance(String key, Object value) {
        if (key == null) {
            return null;
        }
        BeanMap o = new BeanMap();
        o.put(key, value);
        return o;
    }

    public static BeanMap instance(Map<String, Object> attr) {
        if (attr == null) {
            return null;
        }
        BeanMap o = new BeanMap();
        o.putAll(attr);
        return o;
    }

    public static BeanMap instance(Object[][] attr) {
        if (attr == null || attr.length == 0) {
            return null;
        }
        BeanMap o = new BeanMap();
        for (Object[] objects : attr) {
            o.put(ObjectUtils.toString(objects[0]), objects[1]);
        }
        return o;
    }

    public static BeanMap of(String attr) {
        if (StringUtils.isBlank(attr)) {
            return null;
        }
        return JsonUtils.parseBean(attr, BeanMap.class);
    }

    public String getString(String key) {
        return getValue(key, String.class);
    }

    public String getString(String key, String defaultValue) {
        return getValue(key, String.class) == null ? defaultValue : getValue(key, String.class);
    }

    public Integer getInteger(String key) {
        return getValue(key, Integer.class);
    }

    public Integer getInteger(String key, int defaultValue) {
        return getValue(key, Integer.class) == null ? defaultValue : getValue(key, Integer.class);
    }


    public Long getLong(String key) {
        return getValue(key, Long.class);
    }

    public Long getLong(String key, long defaultValue) {
        return getValue(key, Long.class) == null ? defaultValue : getValue(key, Long.class);
    }

    public Double getDouble(String key) {
        return getValue(key, Double.class);
    }

    public Double getDouble(String key, double defaultValue) {
        return getValue(key, Double.class) == null ? defaultValue : getValue(key, Double.class);
    }

    public Float getFloat(String key) {
        return getValue(key, Float.class);
    }

    public Float getFloat(String key, float defaultValue) {
        return getValue(key, Float.class) == null ? defaultValue : getValue(key, Float.class);
    }

    public Short getShort(String key) {
        return getValue(key, Short.class);
    }

    public Short getShort(String key, short defaultValue) {
        return getValue(key, Short.class) == null ? defaultValue : getValue(key, Short.class);
    }

    public Byte getByte(String key) {
        return getValue(key, Byte.class);
    }

    public Byte getByte(String key, byte defaultValue) {
        return getValue(key, Byte.class) == null ? defaultValue : getValue(key, Byte.class);
    }

    public Boolean getBoolean(String key) {
        return getValue(key, Boolean.class);
    }

    public Boolean getBoolean(String key, boolean defaultValue) {
        return getValue(key, Boolean.class) == null ? defaultValue : getValue(key, Boolean.class);
    }

    /**
     * 获取list
     *
     * @param key
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, TypeReference<List<T>> valueTypeRef) {
        return this.getValue(key, valueTypeRef);
    }

    /**
     * 获取<@Link Map
     * @param key
     * @param valueTypeRef
     * @param <T>
     * @return
     */
    public <T> Map<String, T> getMap(String key, TypeReference<Map<String, T>> valueTypeRef) {
        return this.getValue(key, valueTypeRef);
    }

    @SuppressWarnings("Duplicates")
    public <T> T getValue(String key, Class<T> clazz) {
        Object value = this.get(key);
        if (value == null) {
            return null;
        }

        try {
            return JsonUtils.toBean(value, clazz);
        } catch (Exception e) {
            try {
                return JsonUtils.parseBean(value.toString(), clazz);
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    @SuppressWarnings("Duplicates")
    public <T> T getValue(String key, TypeReference valueTypeRef) {
        Object value = this.get(key);
        if (value == null) {
            return null;
        }

        try {
            return JsonUtils.toBean(value, valueTypeRef);
        } catch (Exception e) {
            try {
                return JsonUtils.parseBean(value.toString(), valueTypeRef);
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        }
    }

    @Override
    public String toString() {
        return JsonUtils.toString(this);
    }
}
