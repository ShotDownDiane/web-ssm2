package com.heitian.ssm.dao;

import com.heitian.ssm.db.DBaccess;
import com.heitian.ssm.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Repository
public class UserDao {
    private Logger log = Logger.getLogger(UserDao.class);

    public List<User> selectAllUser(){
        DBaccess dbAccess=new DBaccess();
        SqlSession sqlSession = null;
        List<User> userList=null;
        try {
            sqlSession=dbAccess.getSqlSession();
            log.info("得到了SqlSession");
            userList=sqlSession.selectList("User.selectAllUser");


        }catch (Exception e){
            log.info(e.getMessage());
        }finally {
            sqlSession.close();
        }
        return userList;
    }

    public User findUserByID(String id){
        DBaccess dbAccess = new DBaccess();
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = dbAccess.getSqlSession();
            user = sqlSession.selectOne("User.selectUserById", id);
            log.info(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

}
