package cn.rain.character11;

import cn.rain.character10.pojo.Car10;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 我们知道bean的scope属性如果不配置默认是单例的，但是在这里我们虽然没有配置scope，
 * 但是下面程序返回同一个bean的两个实例竟然是多例的，这是因为我们配置的这个bean继承了FactoryBean，
 * 它不会返回FactoryBean它本身这个实例，而是返回它里面重写的getObject方法返回的实例。并且是否是单例
 * 还要根据它重写的isSingleton方法的返回值来判定。
 * 需要注意一点，如果我们在配置FactoryBean的时候没有指定scope属性，那么理所当然是要依据isSingleton方法
 * 来判断是否为单例，但是如果scope中进行了配置，并且和isSingleton不一致，那么会最终是根据scope的值来确定是否为单例。
 * @author 任伟
 * @date 2018/4/5 18:06
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character11/applicationContext.xml");

        Car10 car1 = (Car10) context.getBean("car1");
        System.out.println(car1);

        Car10 car2= (Car10) context.getBean("car1");
        System.out.println(car1 == car2);


    }
}
