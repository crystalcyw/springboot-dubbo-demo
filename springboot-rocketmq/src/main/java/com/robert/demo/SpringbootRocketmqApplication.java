package com.robert.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyuwei
 * @date 2019-10-24
 */
@Slf4j
@SpringBootApplication
public class SpringbootRocketmqApplication {

  public static void main(String[] args) {

    log.info("springboot-rocketmq 模块正在启动。。。");

    SpringApplication app = new SpringApplication(SpringbootRocketmqApplication.class);
    app.setBannerMode(Mode.OFF);
    app.run(args);

    log.info("springboot-rocketmq 模块启动成功。。。");
  }
}
