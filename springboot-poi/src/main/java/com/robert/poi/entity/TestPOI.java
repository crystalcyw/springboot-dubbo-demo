package com.robert.poi.entity;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author changyuwei
 * @date 2019-10-31
 */
public class TestPOI {

    public static void main(String[] args) throws IOException {

        System.out.println(StandardCharsets.UTF_8.displayName());
        System.out.println(StandardCharsets.UTF_8.name());

        Demo d1 = new Demo(1, "tom");
        Demo d2 = new Demo(1, "jerry");
        Demo d3 = new Demo(1, "dog");
        Demo d4 = new Demo(2, "cat");
        Demo d5 = new Demo(2, "snake");
        Demo d6 = new Demo(3, "fish");
        List<Demo> demos = Lists.newArrayList(d1, d2, d3, d4, d5, d6);
        Multimap<Integer, Demo> multimap = ArrayListMultimap.create();

        for (Demo demo : demos) {
            multimap.put(demo.getId(), demo);
        }

        for (Integer id : multimap.keySet()) {
            Collection<Demo> list = multimap.get(id);
            System.out.println(list);
        }
    }

    @AllArgsConstructor
    @Data
    private static class Demo {

        private Integer id;

        private String name;
    }
}
