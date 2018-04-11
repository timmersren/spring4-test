package cn.rain.character3.service.impl;

import cn.rain.character3.dao.XMLBookShopDao;
import cn.rain.character3.service.XMLBookShopService;

/**
 * description: 演示xml方式配置事务
 * @author 任伟
 * @date create on 2018-04-10 14:14
 **/
public class XMLBookShopServiceImpl implements XMLBookShopService {

    private XMLBookShopDao XMLBookShopDao;

    public void setXMLBookShopDao(XMLBookShopDao XMLBookShopDao) {
        this.XMLBookShopDao = XMLBookShopDao;
    }

    @Override
    public void purchase(String username, Integer isbn) {
        // 1. 查询书的价格
        Integer price = XMLBookShopDao.findBookPriceByIsbn(isbn);
        // 2. 更新该书库存
        XMLBookShopDao.updateBookStack(isbn);
        // 3. 更新用户余额
        XMLBookShopDao.updateUserBalance(username, price);
    }
}
