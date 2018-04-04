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

    @Override
    public String toString() {
        return "Car4{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
