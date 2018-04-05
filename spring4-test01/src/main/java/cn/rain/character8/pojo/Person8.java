package cn.rain.character8.pojo;

/**
 * description:
 * @author 任伟
 * @date 2018/4/5 14:36
 */
public class Person8 {
    private String name;
    private Car8 car;
    /** 这里的city将引用City8中的city属性 */
    private String city;
    /** 根据car的price确定info，如果大于30万info为金领，否则为白领 */
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car8 getCar() {
        return car;
    }

    public void setCar(Car8 car) {
        this.car = car;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Person8{" +
                "name='" + name + '\'' +
                ", car=" + car +
                ", city='" + city + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
