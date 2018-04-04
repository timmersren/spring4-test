package cn.rain.character3.map;

import cn.rain.character2.pojo.Car;

import java.util.Map;

/**
 * description: 演示Map属性的注入
 * @author 任伟
 * @date 2018/4/4 16:23
 */
public class PersonMap {
    private String name;
    private int age;
    private Map<String,Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "PersonMap{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
