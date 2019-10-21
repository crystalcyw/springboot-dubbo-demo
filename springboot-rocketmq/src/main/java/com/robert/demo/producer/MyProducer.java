package com.robert.demo.producer;

import com.robert.demo.constant.RocketmqConstant;
import javax.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author changyuwei
 * @date 2019-10-25
 */
@Service
public class MyProducer {

  @Resource
  private RocketMQTemplate rocketMQTemplate;

  public void send(String message) {
    Message<String> mess = MessageBuilder.withPayload(message).build();
    this.rocketMQTemplate.send(RocketmqConstant.TOPIC, mess);
  }
}
