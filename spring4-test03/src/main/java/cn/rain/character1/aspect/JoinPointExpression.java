package cn.rain.character1.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * description: 我们发现我们前边所定义的连接点的表达式都一样，因此我们最好去服用它，不然当连接点改动的时候所有的
 * 表达式也要进行相应的改动，很容易造成疏漏导致错误。因此在这里我们定义连接点表达式，让所有的切点来引用该表达式。
 * 定义连接点表达式：
 * 1.定义一个方法用于声明切入点表达式，一般该方法中不需要写其他代码。
 * 2.在该方法上通过@Pointcut注解来声明这是一个切入点的表达式。
 * 3.其他切面的切点引用该表达式的时候通过切入点表达式所在的类的 类名.切入点表达式方法名() 来引用表达式。
 *
 * 另外补充说明：
 * 1.如果定义切入点表达式的类和切面不在同一个包下，那么切面中引用该表达式需要： 包名.类名.切入点表达式方法名()
 * 2.定义切入点表达式的类无需加入IoC容器中，也无需声明为切面即可被其他切面引用，因为说到底它仅仅是对字符串的引用。
 *
 * @author 任伟
 * @date 2018/4/9 15:36
 */
public class JoinPointExpression {

    @Pointcut("execution(* cn.rain.character1.calculator.ArithmeticCalculator.*(..))")
    public void declareJoinPointExpression(){
    }
}
