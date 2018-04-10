package cn.rain.character2.service.impl;

import cn.rain.character2.service.BookShopService;
import cn.rain.character2.service.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * description:
 * 1.事务的传播行为
 * 为了演示事务的传播行为，一个用户可以买多本书。这里就存在一个问题，
 * 如果用户一次购买两本书，但是用户的余额不够买两本，但是够买List中的第一本，那么
 * 用户的购买结果是一本书都没买成呢还是买了其中的一本。这取决于我们如何选择事务的
 * 传播行为，如果我们在@Transactional中不配置propagation属性，那么将使用默认的传播
 * 行为Propagation.REQUIRED，spring中共定义了7种事务的传播行为，其中最常用的两种是
 * REQUIRED和REQUIRES_NEW：
 *
 * REQUIRED：如果当前方法调用的方法已经有事务在运行了，那么当前方法就在这个事务中运行，否则
 * 就启动一个新的事务，并在自己的事务内运行。
 *
 * REQUIRES_NEW:它表示该事务注解对应的方法运行时必须启动一个新事务,并在自己的事务内运行。
 * 以这个例子来说purchase方法使用了REQUIRES_NEW，那么在checkout调用purchase方法时，
 * purchase会启动一个新事务tx2,purchase方法将在tx2事务中运行。另外，由于调用者checkout()
 * 中有正在运行的事务tx1，此时checkout()的事务tx1将被暂时挂起,当tx2事务结束后tx1才会继续执行。
 *
 * 2.事务的隔离级别
 * 使用isolation指定事务的隔离级别，最常用的是READ_COMMITTED。
 *
 * 3.指定异常回滚
 * 另外还可以针对某些异常定义是否要回滚,默认情况是对运行时异常进行回滚，也可以自己设置:
 *（1）noRollbackFor: 对于哪些异常不回滚，属性值为Class[]数组，例如
 * noRollbackFor = {AccountBalanceException.class, BookStockException.class}。
 *（2）noRollbackForClassName: 与（1）唯一不同的是这是一个String[]数组，属性值要
 * 传入异常的全路径，例如 noRollbackForClassName = {"cn.rain.character2.exception.AccountBalanceException",
 * "cn.rain.character2.exception.BookStockException"}。
 *（3）rollbackFor: 与（1）相反，设置对哪些异常进行回滚，属性值为Class[]。
 *（4）rollbackForClassName：设置对哪些异常进行回滚，属性值为String[]。
 *
 * 4.只读事务属性(readOnly): 默认是false，如果是一个只读数据库的方法那么设置为true，表示这个事务只读取数据
 * 但不更新数据, 这样可以帮助数据库引擎优化事务。
 *
 * @author 任伟
 * @date create on 2018-04-10 14:53
 **/
@Service("cashierService")
public class CashierServiceImpl implements CashierService {

    @Autowired
    private BookShopService bookShopService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED,
            rollbackFor = {Exception.class},
            readOnly = false
    )
    public void checkout(String username, List<Integer> isbns) {
        for (Integer isbn: isbns) {
            bookShopService.purchase(username, isbn);
        }
    }
}
