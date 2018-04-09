package cn.rain.character2.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * description: 通过xml配置文件方式使用AOP功能的切面。
 * @author 任伟
 * @date 2018/4/9 9:51
 */

@Component("loggingAspect")
public class XMLLoggingAspect {

    public void beforeLog(JoinPoint joinPoint){
        // 获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        List<Object> lstArgs = Arrays.asList(args);
        System.out.println("Before Advice: The method 【" + methodName + "】 will beginning with arguments is " + lstArgs);
    }

    public void afterLog(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After Advice: The method 【" + methodName + "】 execute end!");
    }

    public void returnLog(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterReturning Advice: The method 【" + methodName + "】 execute result is " + result);
    }

    public void exceptionLog(JoinPoint joinPoint, Exception exception){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterThrowing Advice: The method 【" + methodName + "】 current exception is --> " + exception);
    }
}
