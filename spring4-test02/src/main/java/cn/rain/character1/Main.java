package cn.rain.character1;

import cn.rain.character1.controller.UserController1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: 演示通过@Autowired注解自动注入相兼容类型的bean。这里需要注意以下几点：
 * 1.如果使用了@Autowire注解，但是在Ioc容器中并没有兼容的类型存在时，那么注入失败且spring会抛出异常。
 * 如果我们要注入的这个属性可以被忽略，那么可以将@Autowire注解的required属性设置为false，这样spring注入
 * 失败后不会再报错，但是要注意我们后边的程序使用这个属性的方法时要做异常捕捉和处理，不然如果注入失败
 * 后虽然spring不会报错，但是我们调用该属性的方法时会导致空指针异常。代码参见UserController1中注入TestService。
 *
 * 2.我们知道@Autowire会自动注入相兼容的类型，但是如果在Ioc容器中存在多个该类型的时候，会怎么样呢？
 * 首先我们知道使用了@Component、@Service、@Controller、@Repository注解的类将会成为被Ioc容器管理的bean，
 * 并且该bean的默认id为该类类名的首字母小写，我们可以通过value属性来改变它。当有多个兼容的类型时，
 * spring会选择和使用了@Autowired注解的那个属性的属性名一致的那个bean，例如UserService1中使用了@Autowired
 * 的属性是UserDao1类型的且名称叫做userDaoxxx，那么spring便会在Ioc容器找UserDao1类型的bean，如果只存在一个
 * 此类型的bean那么直接注入成功，但是如果存在多个此类型的bean，那么便会在容器中寻找哪个bean的id是userDaoxxx，
 * 如果找到便注入，找不到则报错。因此如果我们想要注入进UserDao1Impl这个实现类，那么我们在标识该类为@Repository
 * 的时候，需要修改这个bean的id为userDaoxxx才能被成功注入；另外一种解决办法就是使用 @Qualifier("userDao1ImplSecond")
 * 注解指定要注入的那个bean的id。
 * 另外说明一点，如果userDaoxxx匹配到了一个bean，同时又使用了@Qualifier("userDao1ImplSecond")也匹配到了一个bean，
 * 那么@Qualifier匹配到的bean的优先级更高，最终会注入UserDao1ImplSecond。
 *
 * 和@Autowired注解类似的注解还有@Resource和@Inject:
 * 1.@Resource是按照bean的名称（即id）进行匹配，使用@Resource(value= "xxx")是需要指定
 * value属性为要注入的bean的id，如果不指定，默认按照使用@Resource注解的属性名或setter方法的方法名(去掉set且首字母小写)。
 * 2.@Inject除了没有required属性外，其余和@Autowired一样。
 * 综上，推荐使用@Autowired（按照类型进行匹配）。
 *
 * @author 任伟
 * @date 2018/4/5 19:32
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("character1/applicationContext.xml");

        UserController1 controller = (UserController1) context.getBean("userController1");
        controller.execute();
    }
}
