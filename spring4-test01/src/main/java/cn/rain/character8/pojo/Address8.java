package cn.rain.character8.pojo;

/**
 * description:
 * @author 任伟
 * @date 2018/4/5 14:38
 */
public class Address8 {
    private String city;
    private String street;

    public Address8(){
        System.out.println("调用Address8的构造器");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        System.out.println("Adrress8的set city方法");
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        System.out.println("Adrress8的set street方法");
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address8{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
