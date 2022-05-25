package com.example.demo.controller;


import com.example.demo.result.LoginResult;
import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceImpl;
import com.example.demo.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Controller
@RequestMapping("/jane/user")
public class UserController {
    @Autowired
   private LoginResult loginResult;
    @Autowired
   UserServiceImpl userService;
    @RequestMapping("/login")
    @ResponseBody
    public LoginResult login(@RequestBody Map<String, String> args){
        /*请求的时候传入账号密码和昵称,头像功能暂时不用*/
        String username = args.get("username");
        String password = args.get("password");
        String nick = args.get("nick");
        if(username == null || password == null){
            loginResult.setState("false");
            loginResult.setMsg("账号或者密码为空");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        if(nick == null)
            user.setNick("未命名用户");
        else
            user.setNick(nick);

        User temp = userService.queryUser(user);
        if(temp == null){
            user.setId(UUIDGenerator.getUUID());
            if(userService.addUser(user) == false){
                loginResult.setState("false");
                loginResult.setMsg("创建账户失败，数据库插入失败！");
            } else {
                loginResult.setState("true");
                loginResult.setMsg("首次登陆，注册成功!");
            }
        } else {
            if(temp.getPassword().equals(user.getPassword())){
                loginResult.setState("true");
                loginResult.setMsg("登陆成功!");
            } else {
                loginResult.setState("false");
                loginResult.setMsg("登陆失败，密码错误!");
            }
        }
        return loginResult;
    }


}
