package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceIMP{
    private Logger log = Logger.getLogger(UserServiceIMP.class);
    @Resource
    private UserDao userDao;
    
    public List<User> getAllUser() {
        log.info("执行到了Service层了");
        return userDao.selectAllUser();
    }

    public User checklogin(String id, String password){
        User user = userDao.findUserByID(id);
        log.info("db " + user.getId() + " " + user.getUserPwd());
        if(user != null&&user.getUserPwd().equals(password)){
            return user;
        } else {
            return null;
        }
    }
}
