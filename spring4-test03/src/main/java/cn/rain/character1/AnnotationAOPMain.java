package cn.rain.character1;

import cn.rain.character1.calculator.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 测试aop功能
 * @author 任伟
 * @date 2018/4/9 9:48
 */
public class AnnotationAOPMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character1/applicationContext.xml");

        ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        // 测试加法
        int result = calculator.add(9, 6);
        System.out.println("result: " + result);
        // 测试除法
        int divResult = calculator.div(12, 4);
        System.out.println("result: " + divResult);


    }
}
