package com.robert.dubbo.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author changyuwei
 * @date 2019-09-20
 */
@Data
@ConfigurationProperties(prefix = "zk")
public class ZookeeperProperties {

     private String url;

     private int timeout;

     private int retry;
}
