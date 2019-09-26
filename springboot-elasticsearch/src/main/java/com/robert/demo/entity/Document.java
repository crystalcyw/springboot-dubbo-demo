package com.robert.demo.entity;

import io.searchbox.annotations.JestId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Data
public class Document {

    @JestId
    private String id;

    private String title;

    private String content;

    private LocalDateTime created;

    private LocalDateTime updated;
}
