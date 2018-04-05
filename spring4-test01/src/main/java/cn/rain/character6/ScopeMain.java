package cn.rain.character6;

import cn.rain.character4.pojo.Car4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示bean的作用域，单例、多例配置。
 * 我们可以看到打印结果中比较car（默认单例）的两个实例是true，car2（scope=prototype）的两个实例比较是false，结果显而易见，不再赘述。
 * 这里要说明的是对构造器的调用，当我们把其他都注释，只保留第一句创建容器那行代码，运行发现调用了Car4的构造器，这是因为
 * 配置了Car4的bean，并且scope使用了默认值singleton，因此在加载Ioc容器时这个bean就会被创建并且加入到容器中，当我们使用这个
 * bean的实例时，直接将容器中初始化时创建的这个bean返回给我们。
 * 而当我们将car2的bean的scope设为prototype情况就不一样了，如果我们把配置文件中car（单例）的配置注释掉，当我们仅仅创建Ioc容器时，
 * 发现并没有调用构造器，而当我们通过context.getBean("car2");得到了两个car2的实例，输出结果也调用了两次构造器，这很明显的说明了
 * 配置bean的时候如果将scope设置成了prototype，那么Ioc容器在加载时不会帮我们创建该bean的实例，而是当我们使用该bean的时候才帮我们
 * 创建实例，并且我们每使用一次该bean的实例都会帮我们调用构造器创建一个新的实例，因此创建的多个实例肯定不是相同的。
 * 也显示调用了两次构造器，
 * @author 任伟
 * @date 2018/4/5 13:33
 */
public class ScopeMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character6/applicationContext.xml");

        Car4 car11 = (Car4) context.getBean("car");
        Car4 car12 = (Car4) context.getBean("car");
        System.out.println(car11 == car12);

        Car4 car21 = (Car4) context.getBean("car2");
        Car4 car22 = (Car4) context.getBean("car2");
        System.out.println(car21 == car22);

    }
}
