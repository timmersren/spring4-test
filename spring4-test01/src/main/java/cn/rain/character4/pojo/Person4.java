package cn.rain.character4.pojo;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/4 16:58
 */
public class Person4 {
    private String name;
    private Address4 address;
    private Car4 car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address4 getAddress() {
        return address;
    }

    public void setAddress(Address4 address) {
        this.address = address;
    }

    public Car4 getCar() {
        return car;
    }

    public void setCar(Car4 car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person4{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", car=" + car +
                '}';
    }
}
