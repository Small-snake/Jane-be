package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    public User queryUser(User user){

        HashMap<String,Object> map = new HashMap<>();
        map.put("username",user.getUsername());
        List<User> userList = userMapper.selectByMap(map);
        if(userList.size() > 0){
            return userList.get(0);
        }
        return null;
    }

    public boolean addUser(User user){
        /*头像功能待拓展*/
        /*请求的时候传入账号密码和昵称*/

        int insert = userMapper.insert(user);
        if(insert > 0){
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUser(User user){
        userMapper.updateById(user);
        return true;
    }
}
