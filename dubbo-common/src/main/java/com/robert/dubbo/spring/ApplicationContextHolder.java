package com.robert.dubbo.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring-IOC 容器
 *
 * @author changyuwei
 * @date 2019-09-11
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext = applicationContext;
    }

    /**
     * 根据名称获取bean
     *
     * @param name 名称
     * @return
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 根据类型获取bean
     * @param clazz 类型
     * @param <T> 泛型
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(Class<T> clazz) throws BeansException {
        return applicationContext.getBean(clazz);
    }

    /**
     * 根据名称和类型获取bean
     *
     * @param name 名称
     * @param clazz 类型
     * @param <T> 泛型
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 获取应用名称
     *
     * @return
     */
    public static String getApplicationName() {
        return applicationContext.getApplicationName();
    }

    /**
     * 获取当前生效的环境
     *
     * @return
     */
    public static String getActiveProfile() {
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }
}
