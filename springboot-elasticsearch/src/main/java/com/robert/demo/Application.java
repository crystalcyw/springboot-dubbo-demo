package com.robert.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        log.info("ElasticSearch 模块正在启动。。。");

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        log.info("ElasticSearch 模块启动成功。。。");
    }
}
