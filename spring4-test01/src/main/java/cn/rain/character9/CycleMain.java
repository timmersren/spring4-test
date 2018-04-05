package cn.rain.character9;

import cn.rain.character9.pojo.Car9;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 这里演示Bean的生命方法，共5个步骤：
 * 1.通过构造器或工厂方法创建Bean的实例。
 * 2.通过setter方法或者引用其他bean的属性为该bean的属性赋值。
 * 3.（如果在配置bean的时候定义了init-method）调用bean的初始化方法。
 * 4.使用这个bean。
 * 5.（如果在配置bean的时候定义了destroy-method）在容器关闭时调用bean的销毁方法。
 * @author 任伟
 * @date 2018/4/5 15:43
 */
public class CycleMain {
    public static void main(String[] args) {
        // 由于ApplicationContext接口没有关闭容器的close方法，因此我们使用其子类的引用
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("character9/applicationContext.xml");

        Car9 car = (Car9) context.getBean("car");
        car.run();

        // 关闭容器
        context.close();
    }
}
