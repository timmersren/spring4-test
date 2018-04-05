package cn.rain.character8;

import cn.rain.character8.pojo.Person8;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 这里对于SpEL表达式不再赘述，而是强调一个有趣的问题。
 * 首先我将Address8中的空参构造器加了一个输出语句，并且在配置Address8的bean的时候将scope设置成了prototype。
 * 我们在character6中讲过，prototype的bean在Ioc容器加载的时候不会被创建，而是当我们用到的时候才会为为我们
 * 创建实例并返回。但是现在的问题是，我们下面这段程序中仅仅是获取了person的bean实例，但是Address8的构造器
 * 却被调用了，这说明Ioc容器为我们创建了Address8的实例，但是我们并未用到它为什么要创建呢？
 * 其实原因就在于我们配置person的bean是注入city属性时#{address.city}，我们引用了address这个bean的city属性，
 * 所以这种链式操作是需要spring来创建address实例的。
 *
 * @author 任伟
 * @date 2018/4/5 14:52
 */
public class SpelMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character8/applicationContext.xml");

        Person8 person = (Person8) context.getBean("person");
        System.out.println(person);
    }
}
