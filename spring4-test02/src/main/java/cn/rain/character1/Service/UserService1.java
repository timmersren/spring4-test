package cn.rain.character1.Service;

import cn.rain.character1.dao.UserDao1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/4/5 19:22
 */
@Service
public class UserService1 {
    @Autowired
//    @Qualifier("userDao1ImplSecond")
    private UserDao1 userDaoxxx;

    public void add(){
        System.out.println("userService1 add...");
        userDaoxxx.save();
    }
}
