package com.eudon.common.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author eudon
 * @version <p>1.0</p>
 * @Description TODO bean注册工具类，使用场景：某些在容器初始化之后才能被确认是否作为bean注册的实例
 * @email syd19970616@gmail.com
 * @repository <a href="https://github.com/EudonSong">GitHub</a>
 * @since 2025/6/4
 */
@Component
public class RegisterBeanUtil implements ApplicationContextAware {
    private static ConfigurableApplicationContext configurableApplicationContext;

    public static void register(String beanName, Class<?> clazz, Object... args) {
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        for (Object arg : args) {
            bdb.addConstructorArgValue(arg);
        }
        AbstractBeanDefinition bd = bdb.getRawBeanDefinition();
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) configurableApplicationContext.getBeanFactory();
        if (!beanFactory.containsBeanDefinition(beanName)) {
            beanFactory.registerBeanDefinition(beanName, bd);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
    }
}
