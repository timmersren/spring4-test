package cn.rain.character10.factory;

import cn.rain.character10.pojo.Car10;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 定义实例工厂，实例工厂和静态工厂的区别：
 * 静态工厂不用创建实例，直接调用其静态方法即可得到Car实例。因此在配置静态工厂的bean时没有对工厂实例的引用。
 * 而实例工厂是要先创建该工厂的实例，想要获取工厂中的元素时需要引用工厂实例并调用其方法来获取，因此我们在
 * 配置实例工厂的时候，先配置了实例工厂的bean。然后获取工厂元素时通过factory-bean属性引用工厂的实例，然后
 * 再调用其方法获取Car的实例。
 *
 * @author 任伟
 * @date 2018/4/5 17:23
 */
public class InstanceCarFactory {
    private Map<String, Car10> carMap;

    // 通过实例工厂的默认构造器进行初始化
    public InstanceCarFactory() {
        System.out.println("调用实例工厂的空参默认构造器初始化");
        carMap = new HashMap<>();
        carMap.put("雪佛兰", new Car10("雪佛兰", 109000.99));
        carMap.put("奥迪", new Car10("奥迪", 329000.99));
    }

    public Car10 getCar(String brand){
        return carMap.get(brand);
    }
}
