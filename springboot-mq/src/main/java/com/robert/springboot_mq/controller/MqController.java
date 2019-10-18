package com.robert.springboot_mq.controller;

import com.robert.dubbo.base.ResponseEntity;
import com.robert.springboot_mq.producer.KafkaProducer;
import java.util.concurrent.ExecutionException;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-10-18
 */
@RestController
public class MqController {

  @Resource
  private KafkaProducer kafkaProducer;

  @RequestMapping("/produce")
  public ResponseEntity produce(@RequestParam(required = false, defaultValue = "hello kafka !") String message)
      throws ExecutionException, InterruptedException {
    this.kafkaProducer.produce(message);
    return ResponseEntity.OK();
  }
}
