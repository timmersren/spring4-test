package cn.rain.character2.service.impl;

import cn.rain.character2.service.BookShopService;
import cn.rain.character2.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description: 为了演示事务的传播行为，一个用户可以买多本书。这里就存在一个问题，
 * 如果用户一次购买两本书，但是用户的余额不够买两本，但是够买List中的第一本，那么
 * 用户的购买结果是一本书都没买成呢还是买了其中的一本。
 * 这取决于我们如何选择事务的传播行为，如果我们在@Transactional中不配置propagation属性，
 * 那么将使用默认的传播行为Propagation.REQUIRED，spring中共定义了7种事务的传播行为。
 *
 * REQUIRED：如果当前方法调用的方法已经有事务在运行了，那么当前方法就在这个事务中运行，否则
 * 就启动一个新的事务，并在自己的事务内运行。
 *
 * REQUIRES_NEW:它表示该事务注解对应的方法运行时必须启动一个新事务,并在自己的事务内运行。
 * 以这个例子来说purchase方法使用了REQUIRES_NEW，那么在checkout调用purchase方法时，
 * purchase会启动一个新事务tx2,purchase方法将在tx2事务中运行。另外，由于调用者checkout()
 * 中有正在运行的事务tx1，此时checkout()的事务tx1将被暂时挂起,当tx2事务结束后tx1才会继续执行。
 *
 * @author 任伟
 * @date create on 2018-04-10 14:53
 **/
@Service("cashierService")
public class CashierServiceImpl implements CashierService {

    @Autowired
    private BookShopService bookShopService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void checkout(String username, List<Integer> isbns) {
        for (Integer isbn: isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
