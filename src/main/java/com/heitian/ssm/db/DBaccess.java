package com.heitian.ssm.db;

/**
 * Created by 53258 on 2017/7/13.
 */
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class DBaccess {
    private Logger log = Logger.getLogger(DBaccess.class);

    public SqlSession getSqlSession() throws IOException{
        log.info("hhhh");
        Reader reader=Resources.getResourceAsReader("config/Configuration.xml");
        log.info("asd");
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        log.info("asdf");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        log.info("asdl");
        return sqlSession;
    }

}
