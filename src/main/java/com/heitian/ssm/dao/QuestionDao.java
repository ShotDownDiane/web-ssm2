package com.heitian.ssm.dao;

import com.heitian.ssm.db.QuestionDBaccess;
import com.heitian.ssm.model.Question;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 53258 on 2017/7/19.
 */
@Repository
public class QuestionDao {
    private Logger log = Logger.getLogger(QuestionDao.class);

    public List<Question> selectQuestionByPage(int page){
        QuestionDBaccess questionDBaccess=new QuestionDBaccess();
        SqlSession sqlSession = null;
        List<Question> questionList=null;
        try {
            sqlSession=questionDBaccess.getSqlSession();
            log.info("得到了SqlSession");
            questionList=sqlSession.selectList("Question.selectQuestionByPage");
            sqlSession.commit();
        }catch (Exception e){
            log.info(e.getMessage());
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return questionList;
    }

    public Question selectQuestionByQID(String questID){
        QuestionDBaccess questionDBaccess=new QuestionDBaccess();
        SqlSession sqlSession = null;
        Question q = null;
        try {
            sqlSession=questionDBaccess.getSqlSession();
            log.info("得到了SqlSession");
            q=sqlSession.selectOne("Question.selectQuestionByQID");
        }catch (Exception e){
            log.info(e.getMessage());
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return q;
    }
    public List<Question> selectQuestionByUID(String userID){
        QuestionDBaccess questionDBaccess=new QuestionDBaccess();
        SqlSession sqlSession = null;
        List<Question> q = null;
        try {
            sqlSession=questionDBaccess.getSqlSession();
            log.info("得到了SqlSession");
            q=sqlSession.selectList("Question.selectQuestionByUID");
        }catch (Exception e){
            log.info(e.getMessage());
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return q;
    }

}
