package cn.rain.character2.service;

import java.util.List;

/**
 * description: 为了演示事务的传播行为
 * @author 任伟
 * @date create on 2018-04-10 14:51
 **/
public interface CashierService {

    /**
    * description: 一个用户可以买多本书
    * @param username 用户名； isbns 多本书的编号List
    **/
    void checkout(String username, List<Integer> isbns);
}
