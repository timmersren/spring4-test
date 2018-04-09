package cn.rain.character1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * description: 这里再定义一个切面，现在就有一个问题了，现在在目标方法上有两个切面存在，
 * 这两个切面肯定都会执行，但是执行顺序如何呢？经过测试我们发现，它们的执行顺序是没有什么
 * 规律可循的，这样由于顺序的混乱就造成了切面之间夹杂着其他切面，严重影响了可读性，
 * 因此我们要设置切面之间的优先级，可以在定义切面的类上是@Order注解来设置优先级，
 * 可以通过@Order中的value属性（int类型）来控制优先级的高低，value值越小优先级越高。
 * @author 任伟
 * @date 2018/4/9 15:09
 */

@Component
@Aspect
@Order(1)
public class PriorityAspect {
//    @Before("execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))")
    @Before("JoinPointExpression.declareJoinPointExpression()") // 引用定义好的切入点表达式
    public void testAdvice(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("---> test priority: the method 【" + methodName + "】 will beginning with arguments is "
                + Arrays.asList(joinPoint.getArgs()));
    }
}
