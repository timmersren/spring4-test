package cn.rain.character3.properties;

import cn.rain.character3.list.PersonList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示配置Properties。
 *
 * @author 任伟
 * @date 2018/4/4 16:34
 */
public class PropMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character3/applicationContext3.xml");

        PropertiesData propData = (PropertiesData) context.getBean("propertiesData");
        System.out.println(propData);

        // 测试引用util:list标签
        PersonList personList = (PersonList) context.getBean("personList2");
        System.out.println(personList);

        // 测试引用util:properties标签
        PropertiesData propData2 = (PropertiesData) context.getBean("propertiesData2");
        System.out.println(propData2);

        // 测试p标签注入属性
        PersonList personList2 = (PersonList) context.getBean("personList3");
        System.out.println(personList2);
    }
}
