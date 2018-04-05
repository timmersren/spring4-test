package cn.rain.character1.controller;

import cn.rain.character1.Service.TestService;
import cn.rain.character1.Service.UserService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * description:
 * @author 任伟
 * @date 2018/4/5 19:22
 */
@Controller
public class UserController1 {

    @Autowired
    private UserService1 userService1;

    @Autowired(required = false)
    private TestService testService;

    public void execute(){
        System.out.println("userController1 execute...");
        try {
            testService.test();
        }catch (NullPointerException e){
            System.out.println("注入TestService失败");
        }
        userService1.add();
    }
}
