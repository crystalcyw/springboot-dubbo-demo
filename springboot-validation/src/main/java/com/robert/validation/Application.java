package com.robert.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyuwei
 * @date 2019-12-24
 */
@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        log.info("spring-boot-validation 模块正在启动。。。");

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Mode.OFF);
        app.run(args);

        log.info("spring-boot-validation 模块启动成功。。。");
    }
}
