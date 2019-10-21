package com.robert.demo.config;

import java.nio.charset.StandardCharsets;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author changyuwei
 * @date 2019-10-24
 */
@Configuration
public class Config {

  @Bean
  public RocketMQTemplate rocketMQTemplate() {
    RocketMQTemplate template = new RocketMQTemplate();
    template.setCharset(StandardCharsets.UTF_8.name());
    return template;
  }
}
