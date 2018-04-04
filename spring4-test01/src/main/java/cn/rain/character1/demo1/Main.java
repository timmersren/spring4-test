package cn.rain.character1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: spring的入门程序。
 * 我们发现当我们注释掉获取bean、调用bean的方法这两步时，依然会调用HelloWorld的构造器。
 * 这就说明了当我们创建Ioc容器时，容器就会帮我们创建好所有的bean并将属性都注入好，而不是
 * 当我们获取某歌Bean的时候才去创建。
 * @author 任伟
 * @date 2018/4/4 14:06
 */
public class Main {
    public static void main(String[] args) {
        // 通过类路径下的xml文件加载IOC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("character1/applicationContext1.xml");
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.hello();
    }
}
