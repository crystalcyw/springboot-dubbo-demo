package com.robert.springboot_mq.handler;

import com.robert.springboot_mq.constant.KafkaConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author changyuwei
 * @date 2019-10-18
 */
@Slf4j
@Component
public class MessageHandler {

  @KafkaListener(topics = {KafkaConstant.TOPIC_TEST}, containerFactory = "ackContainerFactory")
  public void handleMessage(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
    try {
      String value = record.value();
      log.info("接收到主题为: topic_test 的消息:{}" + value);
      System.out.println("接收到主题为: topic_test 的消息:" + value);
    } catch (Exception e) {
      e.printStackTrace();
      log.info("");
    } finally {
      // 手动提交 offset
      acknowledgment.acknowledge();
    }
  }
}
