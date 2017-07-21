package com.heitian.ssm.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by 53258 on 2017/7/20.
 */
public class QuestionDBaccess {

        private Logger log = Logger.getLogger(QuestionDBaccess.class);

        public SqlSession getSqlSession() throws IOException {
            log.info("hhhh");
            Reader reader= Resources.getResourceAsReader("config/QuestionDBconfig.xml");
            log.info("asd");
            SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
            log.info("asdf");
            SqlSession sqlSession = sqlSessionFactory.openSession();
            log.info("asdl");
            return sqlSession;
        }

}

