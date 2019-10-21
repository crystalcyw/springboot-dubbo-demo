package com.robert.demo.producer;

import com.robert.demo.constant.KafkaConstant;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @author changyuwei
 * @date 2019-10-18
 */
@Service
public class KafkaProducer {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void produce(String message) throws ExecutionException, InterruptedException {
    ListenableFuture<SendResult<String, String>> listenableFuture =
        this.kafkaTemplate.send(KafkaConstant.TOPIC_TEST, message);
    if (listenableFuture.isDone()) {
      SendResult<String, String> sendResult = listenableFuture.get();
      String topic = sendResult.getProducerRecord().topic();
      System.out.println("topic: " + topic);
      String key = sendResult.getProducerRecord().key();
      System.out.println("key: " + key);
      String value = sendResult.getProducerRecord().value();
      System.out.println("value: " + value);

      System.err.println("==================================");

      long offset = sendResult.getRecordMetadata().offset();
      System.out.println("offset: " + offset);
      int partition = sendResult.getRecordMetadata().partition();
      System.out.println("partition: " + partition);
      String topic1 = sendResult.getRecordMetadata().topic();
      System.out.println(topic1);
      System.out.println(sendResult.getRecordMetadata().toString());
    }
  }
}
