package cn.rain.character2;

import cn.rain.character2.dao.BookShopDao;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 13:36
 **/
public class TestBookShopDao {

    private ApplicationContext context = null;
    private BookShopDao bookShopDao = null;

    @Before
    public void initBean(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        bookShopDao = (BookShopDao) context.getBean("bookShopDao");
    }

    @Test
    public void testFindBookPriceByIsbn(){
        Integer javaPrice = bookShopDao.findBookPriceByIsbn(1001);
        Integer oraclePrice = bookShopDao.findBookPriceByIsbn(1002);
        assertEquals(Integer.valueOf("100"), javaPrice);
        assertEquals(Integer.valueOf("70"), oraclePrice);
    }

    @Test
    public void testUpdateBookStack(){
        bookShopDao.updateBookStack(1001);
    }

    @Test
    public void testUpdateUserBalance(){
        bookShopDao.updateUserBalance("AA", 100);
    }
}
