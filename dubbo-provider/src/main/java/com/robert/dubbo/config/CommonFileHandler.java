package com.robert.dubbo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author changyuwei
 * @date 2019-09-24
 */
@Slf4j
@Component
public class CommonFileHandler implements MetaObjectHandler {
    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert fill start ...");
        this.setInsertFieldValByName("gmt_created", LocalDateTime.now(), metaObject);
        this.setInsertFieldValByName("gmt_updated", LocalDateTime.now(), metaObject);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateFieldValByName("gmt_updated", LocalDateTime.now(), metaObject);
    }
}
