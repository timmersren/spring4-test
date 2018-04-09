package cn.rain.character2.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description: 定义参数验证的切面，切入点定义使用前置通知获取连接点传入的参数，这里省略后续的验证步骤。
 * @author 任伟
 * @date 2018/4/9 16:02
 */
@Component("validationAspect")
public class XMLValidationAspect {

    public void validateParams(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---> validate parameters : the method 【" + methodName + "】 will beginning with arguments is "
                + Arrays.asList(joinPoint.getArgs()));
    }
}
