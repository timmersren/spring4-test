package cn.rain.character5;

import cn.rain.character4.pojo.Address4;
import cn.rain.character4.pojo.Car4;
import cn.rain.character4.pojo.Person4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示bean的依赖和继承。
 * @author 任伟
 * @date 2018/4/4 17:54
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character5/applicationContext5.xml");

        Address4 address = (Address4) context.getBean("address");
        Address4 address2 = (Address4) context.getBean("address2");
        System.out.println(address);
        System.out.println(address2);

        //演示car2的bean继承了模板bean。
        Car4 car = (Car4) context.getBean("car2");
        System.out.println(car);

        //演示person的bean依赖address
        Person4 person = (Person4) context.getBean("person");
        System.out.println(person);
    }
}
