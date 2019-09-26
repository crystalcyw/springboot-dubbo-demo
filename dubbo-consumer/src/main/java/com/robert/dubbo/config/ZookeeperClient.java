package com.robert.dubbo.config;

import com.alibaba.dubbo.remoting.zookeeper.curator.CuratorZookeeperClient;
import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

/**
 * @author changyuwei
 * @date 2019-09-20
 */
public class ZookeeperClient {

    @Getter
    private CuratorZookeeperClient zookeeperClient;

    @Getter
    private CuratorFramework curatorFramework;

    public ZookeeperClient(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    /**
     * 创建节点
     *
     * @param path       路径
     * @param data
     * @param createMode 创建模式
     */
    public void creatNode(String path, String data, CreateMode createMode) {
        try {
            curatorFramework.create().creatingParentContainersIfNeeded()
                    .withMode(createMode).forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据路径查询节点
     *
     * @param path 路径
     * @return
     */
    public String queryNode(String path) {
        try {
            byte[] data = curatorFramework.getData().forPath(path);
            if (ArrayUtils.isNotEmpty(data)) {
                return new String(data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
