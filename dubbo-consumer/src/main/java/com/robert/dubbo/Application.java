package com.robert.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyuwei
 * @date 2019-09-10
 */
@Slf4j
@EnableDubboConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        log.info("Dubbo consumer 开始启动。。。");

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        log.info("Dubbo consumer 启动成功。。。");
    }
}
