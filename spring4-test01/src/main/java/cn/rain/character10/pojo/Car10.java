package cn.rain.character10.pojo;

/**
 * @author 任伟
 * @date 2018/4/5 17:01
 */
public class Car10 {
    private String brand;
    private double price;

    public Car10(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

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

    @Override
    public String toString() {
        return "Car10{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
