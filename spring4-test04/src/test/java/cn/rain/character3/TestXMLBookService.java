package cn.rain.character3;

import cn.rain.character3.service.XMLBookShopService;
import cn.rain.character3.service.XMLCashierService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author 任伟
 * @date create on 2018-04-10 14:18
 **/
public class TestXMLBookService {

    private ApplicationContext context = null;
    private XMLBookShopService bookShopService = null;
    private XMLCashierService cashierService = null;

    @Before
    public void initBean(){
        context = new ClassPathXmlApplicationContext("character3/applicationContext-tx.xml");
        bookShopService = (XMLBookShopService) context.getBean("bookShopService");
        cashierService = (XMLCashierService) context.getBean("cashierService");
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
