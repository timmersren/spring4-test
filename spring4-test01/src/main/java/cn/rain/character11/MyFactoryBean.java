package cn.rain.character11;

import cn.rain.character10.pojo.Car10;
import org.springframework.beans.factory.FactoryBean;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/5 18:02
 */
public class MyFactoryBean implements FactoryBean {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 返回FactoryBean创建的实例
     */
    @Override
    public Object getObject()  {
        return new Car10(brand, 50000.99);
    }

    /**
     * 返回FactoryBean创建的实例的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Car10.class;
    }

    /**
     * FactoryBean创建的实例是否为单例
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
