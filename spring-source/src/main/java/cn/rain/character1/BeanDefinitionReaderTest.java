package cn.rain.character1;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * 演示BeanDefinitionReader装载过程，即手动将Bean注册到Bean的注册中心
 *
 * @author 左边
 * @date 2020/2/26 3:31 上午
 */
public class BeanDefinitionReaderTest {
    public static void main(String[] args) {
        // 创建bean注册中心
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        // 创建BeanDefinition读取器（需要指定注册中心，即读取的bean定义要注册到哪里）
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);

        // 创建资源加载器
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        // 读取资源（bean配置文件）
        Resource resource = resourceLoader.getResource("spring.xml");

        // 对资源中的bean进行注册
        reader.loadBeanDefinitions(resource);

        System.out.println(Arrays.toString(registry.getBeanDefinitionNames()));
    }
}
