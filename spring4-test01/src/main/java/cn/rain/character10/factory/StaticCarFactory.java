package cn.rain.character10.factory;

import cn.rain.character10.pojo.Car10;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 定义静态工厂
 * @author 任伟
 * @date 2018/4/5 17:00
 */
public class StaticCarFactory {

    // 定义一个装不同品牌车的Map
    private static Map<String, Car10> carMap = new HashMap<>();
    // 使用static块进行初始化，将不同的车装进map中
    static {
        System.out.println("通过静态代码块对静态工厂进行初始化");
        carMap.put("雪佛兰", new Car10("雪佛兰", 109000.99));
        carMap.put("奥迪", new Car10("奥迪", 329000.99));
    }

    // 定义返回Car实例的静态方法
    public static Car10 getCar(String brand){
        return carMap.get(brand);
    }
}
