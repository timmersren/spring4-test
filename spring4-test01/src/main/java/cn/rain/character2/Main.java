package cn.rain.character2;

import cn.rain.character2.pojo.Car;
import cn.rain.character2.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示通过构造器为bean注入属性。
 * @author 任伟
 * @date 2018/4/4 14:31
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character2/applicationContext2.xml");
        Car car = (Car) context.getBean("car");
        System.out.println(car);

        Car car2 = (Car) context.getBean("car2");
        System.out.println(car2);

        Person person = (Person) context.getBean("person1");
        System.out.println(person);

        Person person2 = (Person) context.getBean("person2");
        System.out.println(person2);

    }
}
