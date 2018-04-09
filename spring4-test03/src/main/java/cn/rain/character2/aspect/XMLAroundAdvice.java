package cn.rain.character2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * description: 定义通过xml配置文件配置的环绕通知的切面。
 * @author 任伟
 * @date 2018/4/9 14:38
 */

@Component("aroundAspect")
@SuppressWarnings("all")
public class XMLAroundAdvice {

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
