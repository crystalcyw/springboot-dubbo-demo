package com.robert.dubbo;

import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author changyuwei
 * @date 2019-09-21
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Resource
    private CuratorFramework curatorFramework;

    @Resource
    private CuratorZookeeperClient curatorZookeeperClient;

    @Test
    public void testCuratorFramework() {
        try {
            String data = this.curatorFramework.create().forPath("/zookeeper");
            log.info("[CuratorFramework]执行完毕！结果是:{}" + data);
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCuratorZookeeperClient() {
        this.curatorZookeeperClient.createEphemeral("/zookeeper");
        log.info("[CuratorZookeeperClient]执行完毕！");
    }
}
