package com.robert.demo.consumer;

import com.robert.demo.constant.RocketmqConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * @author changyuwei
 * @date 2019-10-25
 */
@Slf4j
@Service
@RocketMQMessageListener(
    topic = RocketmqConstant.TOPIC,
    consumerGroup = RocketmqConstant.CONSUMER_GROUP
)
public class MyConsumer implements RocketMQListener<String> {

  @Override
  public void onMessage(String message) {
    log.info("MyConsumer 接收到消息:{}", message);
    System.out.println("MyConsumer 接收到消息:{}" + message);
  }
}
