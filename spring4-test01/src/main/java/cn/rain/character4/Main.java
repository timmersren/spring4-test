package cn.rain.character4;

import cn.rain.character4.pojo.Person4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/4 17:13
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character4/applicationContext4.xml");

        Person4 person = (Person4) context.getBean("person");
        System.out.println(person);
    }
}
