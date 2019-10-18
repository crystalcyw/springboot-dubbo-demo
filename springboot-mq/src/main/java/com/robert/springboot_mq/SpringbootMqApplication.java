package com.robert.springboot_mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changyuwei
 */
@Slf4j
@SpringBootApplication
public class SpringbootMqApplication {

  public static void main(String[] args) {

    log.info("springboot-mq 模块正在启动。。。");

    SpringApplication application = new SpringApplication(SpringbootMqApplication.class);
    application.setBannerMode(Mode.OFF);
    application.run(args);

    log.info("springboot-mq 模块启动成功。。。");
  }
}
