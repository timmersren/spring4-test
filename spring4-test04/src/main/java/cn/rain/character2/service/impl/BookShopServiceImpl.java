package cn.rain.character2.service.impl;

import cn.rain.character2.dao.BookShopDao;
import cn.rain.character2.exception.BookStockException;
import cn.rain.character2.service.BookShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void purchase(String username, Integer isbn) {
        // 1. 查询书的价格
        Integer price = bookShopDao.findBookPriceByIsbn(isbn);
        // 2. 更新该书库存
        bookShopDao.updateBookStack(isbn);
        // 3. 更新用户余额
        bookShopDao.updateUserBalance(username, price);
    }
}
