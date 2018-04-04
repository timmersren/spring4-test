package cn.rain.character3.map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示为Map属性注入值。
 * @author 任伟
 * @date 2018/4/4 16:28
 */
public class MapMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character3/applicationContext3.xml");

        PersonMap personMap = (PersonMap) context.getBean("personMap");
        System.out.println(personMap);
    }
}
