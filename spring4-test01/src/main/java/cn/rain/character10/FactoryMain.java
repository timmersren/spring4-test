package cn.rain.character10;

import cn.rain.character10.pojo.Car10;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示通过工厂获取工厂返回的实例。
 * @author 任伟
 * @date 2018/4/5 17:10
 */
public class FactoryMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character10/applicationContext.xml");

        // 通过静态工厂获取Car实例
        Car10 car = (Car10) context.getBean("car");
        System.out.println(car);

        // 通过实例工厂获取Car实例
        Car10 car2 = (Car10) context.getBean("car2");
        System.out.println(car2);

    }
}
