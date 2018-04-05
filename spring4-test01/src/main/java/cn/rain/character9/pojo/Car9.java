package cn.rain.character9.pojo;

/**
 * description:
 * @author 任伟
 * @date 2018/4/5 15:03
 */
public class Car9 {
    private String brand;

    /** 定义Car9初始化方法 */
    public void init(){
        System.out.println("Car9的初始化方法");
    }

    /** 定义Car9的销毁方法 */
    public void destroy(){
        System.out.println("Car9的销毁方法");
    }

    public void run(){
        System.out.println("Car9自己拥有的方法");
    }

    public Car9() {
        System.out.println("Car9的构造器");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用Car9的setter方法");
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car9{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
