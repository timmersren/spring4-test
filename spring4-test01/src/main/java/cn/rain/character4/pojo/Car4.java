package cn.rain.character4.pojo;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/4 16:59
 */
public class Car4 {
    private String brand;
    private double price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Car4() {
        System.out.println("调用Car4的构造器");
    }

    @Override
    public String toString() {
        return "Car4{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
