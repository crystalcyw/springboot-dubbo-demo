package com.robert.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 整合 kafka 启动类
 *
 * @author changyuwei
 */
@Slf4j
@SpringBootApplication
public class SpringbootKafkaApplication {

  public static void main(String[] args) {

    log.info("spring-boot-kafka 模块正在启动。。。");

    SpringApplication application = new SpringApplication(SpringbootKafkaApplication.class);
    application.setBannerMode(Mode.OFF);
    application.run(args);

    log.info("spring-boot-kafka 模块启动成功。。。");
  }
}
