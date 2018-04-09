package cn.rain.character1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * description: 重新定义一个切面演示环绕通知，环绕通知是所有通知中最全面的，但是不常用。
 * 为什么说它是最全面的，环绕通知其实并不是一种新的通知类型，而是集合了前面四种通知，
 * 使用环绕通知可以完成其他四种通知能完成的效果。
 *
 * 环绕通知，类似于一个动态代理的全过程，使用环绕通知要求：
 * 1.在定义横切关注点的时候参数列表中必须传入ProceedingJoinPoint参数，
 * ProceedingJoinPoint可以执行连接点（即目标方法）的方法。
 * 2.环绕通知的横切关注点必须有返回值，且返回值即为连接点（即目标方法）的返回值。
 *
 * @author 任伟
 * @date 2018/4/9 14:38
 */

@Component
@Aspect
@Order(2)
public class LoggingAspectAroundAdvice {

    @Around("execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        // 通过ProceedingJoinPoint获取连接点的方法名
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 获取连接点的参数
        Object[] args = proceedingJoinPoint.getArgs();
        List<Object> lstArgs = Arrays.asList(args);

        Object result = null;
        try {
            // 1. 定义前置通知
            System.out.println("Before Advice from ==Around Advice==: The method 【" + methodName + "】 will beginning with arguments is " + lstArgs);
            // 通过ProceedingJoinPoint执行目标方法，正因为能执行目标方法所以才能模拟动态代理的整个过程
            result = proceedingJoinPoint.proceed();
            // 2.定义返回通知
            System.out.println("AfterReturning Advice from ==Around Advice==: The method 【" + methodName + "】 execute result is " + result);

        } catch (Throwable throwable) {
            // 3.定义异常通知
            System.out.println("AfterThrowing Advice from ==Around Advice==: The method 【" + methodName + "】 current exception is --> " + throwable);
            throwable.printStackTrace();
        }
        // 4.定义后置通知
        System.out.println("After Advice from ==Around Advice==: The method 【" + methodName + "】 execute end!");

        // 返回环绕通知的结果（即目标方法的结果）
        return result;
    }
}
