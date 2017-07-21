package com.heitian.ssm.service.impl;

import com.heitian.ssm.dao.QuestionDao;
import com.heitian.ssm.dao.UserDao;
import com.heitian.ssm.model.Question;
import com.heitian.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 53258 on 2017/7/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionServiceIMP {
    private Logger log = Logger.getLogger(QuestionServiceIMP.class);
    @Resource
    private QuestionDao questionDao;

    public List<Question> getAllQuestion(int page) {
        return questionDao.selectQuestionByPage(page);
    }
    public Question getQuestionByQID(String questID) {
        return questionDao.selectQuestionByQID(questID);
    }
    public List<Question> getQuestionByUID(String userID) {
        return questionDao.selectQuestionByUID(userID);
    }
    public List<Question> getQuestionByPage(int page) {
        return questionDao.selectQuestionByPage(page);
    }
}