package cn.rain.character1.demo1;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/4 14:02
 */
public class HelloWorld {
    private String userName;

    public void setUserName(String userName) {
        System.out.println("调用setter方法给userName属性赋值...");
        this.userName = userName;
    }

    public void hello(){
        System.out.println("hello " + userName);
    }

    public HelloWorld() {
        System.out.println("调用HelloWorld的无参构造器...");
    }
}
