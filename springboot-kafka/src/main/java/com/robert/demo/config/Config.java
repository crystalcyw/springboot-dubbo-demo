package com.robert.demo.config;

import com.robert.demo.constant.KafkaConstant;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;

/**
 * kafka 配置文件
 *
 * @author changyuwei
 * @date 2019-10-17
 */
@AllArgsConstructor
@EnableKafka
@Configuration
@EnableConfigurationProperties({KafkaProperties.class})
public class Config {

  @Autowired
  private final KafkaProperties kafkaProperties;

  @Bean
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(kafkaProducerFactory());
  }

  @Bean
  public ProducerFactory<String, String> kafkaProducerFactory() {
    return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
  }

  @Bean
  public ConsumerFactory<String, String> kafkaConsumerFactory() {
    return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory
        = new ConcurrentKafkaListenerContainerFactory<>();
    kafkaListenerContainerFactory.setConsumerFactory(kafkaConsumerFactory());
    kafkaListenerContainerFactory.setConcurrency(KafkaConstant.DEFAULT_PARTATION_NUM);
    kafkaListenerContainerFactory.setBatchListener(true);
    kafkaListenerContainerFactory.getContainerProperties().setPollTimeout(3000);
    return kafkaListenerContainerFactory;
  }

  @Bean("ackContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<String, String> ackContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, String> ackContainerFactory
        = new ConcurrentKafkaListenerContainerFactory<>();
    ackContainerFactory.setConsumerFactory(kafkaConsumerFactory());
    ackContainerFactory.setConcurrency(KafkaConstant.DEFAULT_PARTATION_NUM);
    ackContainerFactory.getContainerProperties().setAckMode(AckMode.MANUAL_IMMEDIATE);
    return ackContainerFactory;
  }
}
