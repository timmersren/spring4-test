package cn.rain.character1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * description: 创建日志切面，并配置要记录的日志（即切入点）。
 * 要配置切入点需要两个步骤（注解）：
 * 1.声明切入点所在的类为切面，使用@Aspect注解
 * 2.将切面放入到IoC容器中，使用@Component注解（@Service等同类注解亦可）。
 *
 * 切面配置完以后，还需要在spring的xml配置文件中使我们这里的@Aspect注解起作用并且为匹配到的要切入的方法所在的类
 * 创建代理对象，我们可以使用aspect的自动创建代理对象的配置来为目标方法所在类自动创建代理对象。
 *
 * @author 任伟
 * @date 2018/4/9 9:51
 */

//@Component
//@Aspect 因为要测试环绕通知，故这里先注释掉。
public class LoggingAspect {
    /**
     * 配置切入点，需要声明该方法（即横切关注点）的通知类型，这里使用@Before注解声明为前置通知。
     * 其中@Before注解的value属性配置要切入的目标方法，使用AspectJ表达式。
     * AspectJ共支持五种通知：
     * @Before: 前置通知, 在方法执行之前执行
     * @After: 后置通知, 在方法执行之后执行
     * @AfterRunning: 返回通知, 在方法返回结果之后执行
     * @AfterThrowing: 异常通知, 在方法抛出异常之后
     * @Around: 环绕通知, 围绕着方法执行
     *
     * 另外，我们在定义切入点的时候加入JoinPoint参数可以获取到目标方法的方法名和方法参数列表等信息。
     */
    @Before("execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))")
    public void beforeLog(JoinPoint joinPoint){
        // 获取目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取目标方法的参数列表
        Object[] args = joinPoint.getArgs();
        List<Object> lstArgs = Arrays.asList(args);
        System.out.println("Before Advice: The method 【" + methodName + "】 will beginning with arguments is " + lstArgs);
    }

    /**
     * 后置通知：在目标方法执行之后执行的通知，无论是否发生异常都会执行。
     * 需要注意的是，后置通知无法访问目标方法执行的结果（即返回值）。
     * 想要访问目标方法的执行结果（即返回值）需要使用返回通知。
     */
    @After("execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))")
    public void afterLog(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("After Advice: The method 【" + methodName + "】 execute end!");
    }

    /**
     * 返回通知：无论连接点是正常返回还是抛出异常, 后置通知都会执行。
     * 但如果只想记录连接点（即目标方法）的返回结果, 应使用返回通知代替后置通知。
     * 注意：如果连接点发生异常，那么将得不到结果，因此也就没有返回值，所以返回通知
     * 也不会有记录。即返回通知在发生异常的时候不会执行。
     */
    @AfterReturning(value = "execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))",
    returning = "result")
    public void returnLog(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterReturning Advice: The method 【" + methodName + "】 execute result is " + result);
    }

    /**
     * 异常通知：在目标方法出现异常时会执行的通知，可以访问到异常对象。并且可以通过
     * 指定特定的异常从而对该特定的异常执行通知，如下面的参数Exception，这里只要是发成
     * Exception便会执行该异常通知，如果将Exception改为NullPointException，那么只有当
     * 出现空指针异常时该异常通知才会执行。
     */
    @AfterThrowing(value = "execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))",
            throwing = "exception")
    public void exceptionLog(JoinPoint joinPoint, Exception exception){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("AfterThrowing Advice: The method 【" + methodName + "】 current exception is --> " + exception);
    }
}
