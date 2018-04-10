package cn.rain.character2.service.impl;

import cn.rain.character2.dao.BookShopDao;
import cn.rain.character2.exception.AccountBalanceException;
import cn.rain.character2.exception.BookStockException;
import cn.rain.character2.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 任伟
 * @date create on 2018-04-10 14:14
 **/
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    /**
     * 超时事务属性(timeout): 可以为该事务设置超时时间，单位是秒。
     * 如果超过了设置的超时时间事务仍未完成，那么将进行强制回滚。
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,
            rollbackFor = {Exception.class},
            timeout = 3
    )
    @Override
    public void purchase(String username, Integer isbn) {
        // 测试事务的timeout属性，这里sleep 4秒，超过了timeout的3秒，那么即使方法可以正确执行也会被强制回滚
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 1. 查询书的价格
        Integer price = bookShopDao.findBookPriceByIsbn(isbn);
        // 2. 更新该书库存
        bookShopDao.updateBookStack(isbn);
        // 3. 更新用户余额
        bookShopDao.updateUserBalance(username, price);
    }
}
