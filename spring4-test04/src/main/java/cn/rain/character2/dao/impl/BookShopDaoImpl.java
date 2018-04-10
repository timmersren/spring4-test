package cn.rain.character2.dao.impl;

import cn.rain.character2.dao.BookShopDao;
import cn.rain.character2.exception.AccountBalanceException;
import cn.rain.character2.exception.BookStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author 任伟
 * @date create on 2018-04-10 13:27
 **/

@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer findBookPriceByIsbn(Integer isbn) {
        String sql = " SELECT price from book WHERE isbn = ? ";
        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    @Override
    public void updateBookStack(Integer isbn) {
        // 检查该书是否还有库存
        String checkStockSql = " SELECT stock from book_stock WHERE isbn = ? ";
        Integer stockNum = jdbcTemplate.queryForObject(checkStockSql, Integer.class, isbn);
        if (stockNum == 0){
            throw new BookStockException();
        }
        // 更新该书的库存
        String sql = " UPDATE book_stock SET stock = stock - 1 WHERE isbn = ? ";
        jdbcTemplate.update(sql, isbn);
    }

    @Override
    public void updateUserBalance(String username, Integer price) {
        // 检查用户余额是否充足
        String checkStockSql = " SELECT balance from account WHERE username = ? ";
        Integer currentBalance = jdbcTemplate.queryForObject(checkStockSql, Integer.class, username);
        if (currentBalance < price){
            throw new AccountBalanceException();
        }
        // 更新用户余额
        String sql = " UPDATE account SET balance = balance - ? WHERE username = ? ";
        jdbcTemplate.update(sql, price, username);
    }
}
