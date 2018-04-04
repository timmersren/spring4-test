package cn.rain.character2.pojo;

/**
 * description: 演示通过构造器注入属性（character1是通过set方法）。
 * @author 任伟
 * @date 2018/4/4 14:20
 */
public class Car {
    /** 品牌名 */
    private String brand;
    /** 厂家 */
    private String crop;
    /** 售价 */
    private double price;
    /** 最大速度 */
    private int maxSpeed;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String brand, String crop, double price) {
        this.brand = brand;
        this.crop = crop;
        this.price = price;
    }

    public Car(String brand, String crop, int maxSpeed) {
        this.brand = brand;
        this.crop = crop;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car4{" +
                "brand='" + brand + '\'' +
                ", crop='" + crop + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
