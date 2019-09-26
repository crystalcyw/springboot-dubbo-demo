package com.robert.dubbo.config;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperClient;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.robert.dubbo.base.ApplicationContextHolder;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Configuration
@EnableConfigurationProperties(ZookeeperProperties.class)
public class Config {

    @Resource
    private final ZookeeperProperties zookeeperProperties;

    public Config(ZookeeperProperties zookeeperProperties) {
        this.zookeeperProperties = zookeeperProperties;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Primary
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }

    @Bean
    public ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }

    /**
     * apache 提供的 zookeeper client
     *
     * @return
     */
    @Bean
    public CuratorFramework curatorFramework() {
        RetryPolicy retry = new ExponentialBackoffRetry(zookeeperProperties.getTimeout(),
                zookeeperProperties.getRetry());
        CuratorFramework zkClient = CuratorFrameworkFactory.newClient(zookeeperProperties.getUrl(), retry);
        zkClient.start();
        return zkClient;
    }

    /**
     * dubbo 提供的 zookeeper client
     *
     * @return
     */
    @Bean
    public CuratorZookeeperClient curatorZookeeperClient() {
        URL url = URL.valueOf(zookeeperProperties.getUrl());
        return new CuratorZookeeperClient(url);
    }
}
