package cn.rain.character3.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/4 15:27
 */
public class ListMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character3/applicationContext3.xml");

        PersonList personList = (PersonList)context.getBean("personList");
        System.out.println(personList);
    }
}
