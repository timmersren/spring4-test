package cn.rain.character9;

import cn.rain.character8.pojo.Address8;
import cn.rain.character9.pojo.Car9;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示配置了Bean后置处理器后的效果，所有的bean的生命周期都会增加两个步骤，即在调用bean的init-method前后
 * 会加入Bean后置处理的两个重写方法的处理。如果bean中没有配置init-method，那么后置处理器的两个方法将会在bean的属性
 * 赋值（setter方法或者引用其他bean的属性）之后且使用bean之前进行处理，使用了bean的后置处理器后，bean的完整生命周期为：
 * 1.通过构造器或工厂方法创建Bean的实例。
 * 2.通过setter方法或者引用其他bean的属性为该bean的属性赋值。
 * 3.调用BeanPostProcessor的postProcessBeforeInitialization方法。
 * 4.（如果在配置bean的时候定义了init-method）调用bean的初始化方法。
 * 5.调用BeanPostProcessor的postProcessAfterInitialization方法
 * 6.使用这个bean。
 * 7.（如果在配置bean的时候定义了destroy-method）在容器关闭时调用bean的销毁方法。
 * @author 任伟
 * @date 2018/4/5 16:10
 */
public class BeanProcessorMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("character9/beanPostProcessor.xml");

        Car9 car = (Car9) context.getBean("car");
        car.run();
        Address8 address = (Address8) context.getBean("address");
        String city = address.getCity();
        System.out.println("获取Address8的city：" + city);

        context.close();

    }
}
