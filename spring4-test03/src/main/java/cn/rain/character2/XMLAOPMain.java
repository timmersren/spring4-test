package cn.rain.character2;

import cn.rain.character1.calculator.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/9 16:09
 */
public class XMLAOPMain {
    public static void main(String[] args) {
        // 测试四种普通通知
//        ApplicationContext context = new ClassPathXmlApplicationContext("character2/applicationContext.xml");
        // 测试环绕通知
        ApplicationContext context = new ClassPathXmlApplicationContext("character2/applicationContext2.xml");

        ArithmeticCalculator calculator = (ArithmeticCalculator) context.getBean("arithmeticCalculator");
        // 测试加法
        int result = calculator.add(9, 6);
        System.out.println("result: " + result);
        // 测试除法
        int divResult = calculator.div(12, 4);
        System.out.println("result: " + divResult);

    }
}
