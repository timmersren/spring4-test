package cn.rain.character2;

import cn.rain.character2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示spring4的新特性--泛型依赖注入。
 * 我们并没有在UserService中注入UserDao，但是我们看到当我们调用UserService的add方法时，
 * 输出结果中却也调用了UserDao的add方法，其实这是因为UserService继承了BaseService，而在
 * 父类BaseService中对BaseDao进行了引用，而我们创建的子类继承了这种引用关系。
 *
 * @author 任伟
 * @date 2018/4/5 23:50
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character2/applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");
        userService.add();
    }
}
