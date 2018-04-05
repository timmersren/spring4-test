package cn.rain.character1.dao.impl;

import cn.rain.character1.dao.UserDao1;
import org.springframework.stereotype.Repository;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/5 19:23
 */
@Repository("userDaoxxx")
public class UserDao1Impl implements UserDao1 {
    @Override
    public void save() {
        System.out.println("UserDao1Impl save...");
    }
}
