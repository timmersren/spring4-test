package cn.rain.character2.service;

import cn.rain.character2.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/5 23:45
 */
public class BaseService<T> {

    @Autowired
    protected BaseDao<T> baseDao;

    public void add(){
        System.out.println("this is BaseService's add method");
        baseDao.add();
    }
}
