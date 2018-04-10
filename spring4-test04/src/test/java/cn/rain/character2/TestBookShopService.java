package cn.rain.character2;

import cn.rain.character2.service.BookShopService;
import cn.rain.character2.service.CashierService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author 任伟
 * @date create on 2018-04-10 14:18
 **/
public class TestBookShopService {

    private ApplicationContext context = null;
    private BookShopService bookShopService = null;
    private CashierService cashierService = null;

    @Before
    public void initBean(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopService = (BookShopService) context.getBean("bookShopService");
        cashierService = (CashierService) context.getBean("cashierService");
    }

    @Test
    public void testBookService(){ // 测试事务
        bookShopService.purchase("AA", 1001);
    }

    @Test
    public void testTransactionPropagation(){ // 测试事务的传播行为
        cashierService.checkout("AA", Arrays.asList(1001, 1002));
    }
}
