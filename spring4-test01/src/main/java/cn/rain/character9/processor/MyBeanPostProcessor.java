package cn.rain.character9.processor;

import cn.rain.character9.pojo.Car9;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * description: 演示定义Bean的后置处理器。
 * 后置处理器的作用：可以在所有bean初始化（也就是init方法）之前和之后对其进行额外的处理。
 * 定义Bean后置处理器的方法：
 * 1.实现BeanPostProcessor接口。
 * 2.实现该接口的两个抽象方法：
 * 重写postProcessBeforeInitialization方法将在init之前进行自定义处理，
 * 重写postProcessAfterInitialization方法将在init之后进行自定义处理。
 *
 * 注意：后置处理器对容器中所有的bean都会进行处理，不能单单指定某一个bean处理。
 *
 * @author 任伟
 * @date 2018/4/5 15:59
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean的后置处理器在调用" + beanName + "的init方法之前进行处理..." + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Bean的后置处理器在调用" + beanName + "的init方法之后进行处理..." + bean);

        // 如果我在这里进行下面这个操作，可以使Ioc容器中每个Bean都成为Car9。
        // Bean后置处理器既然是在为Bean的属性赋值后才执行，因此它最常用的情景就是检查bean赋值的正确性。
//        Car9 car = new Car9();
//        car.setBrand("福特");
//        return car;

        return bean;
    }
}
