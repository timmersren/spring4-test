package cn.rain.character3.list;

import cn.rain.character2.pojo.Car;

import java.util.List;

/**
 * description: 演示为List集合注入属性，这里定义Person有多辆Car。
 * @author 任伟
 * @date 2018/4/4 15:20
 */
public class PersonList {
    private String name;
    private int age;
    private List<Car> cars;

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "PersonList{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                '}';
    }
}
