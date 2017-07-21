package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.heitian.ssm.model.Question;
import com.heitian.ssm.model.User;
import com.heitian.ssm.service.impl.QuestionServiceIMP;
import com.heitian.ssm.service.impl.UserServiceIMP;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * Created by 53258 on 2017/7/19.
 */
@Controller
@RequestMapping("/question")
public class QuestionPage {
    private Logger log = Logger.getLogger(UserController.class);
    @Resource
    private QuestionServiceIMP questionServiceIMP;

    @RequestMapping("/showQuestion")//展示所有的问题
    @ResponseBody
    public String showQuestion(HttpServletRequest request, HttpServletResponse respone,@RequestParam("page")int page){
        log.info("查询所有问题信息");
        List<Question> questionList = questionServiceIMP.getQuestionByPage(page);
        JSONArray jsonArray= JSONArray.fromObject(questionList);
        return jsonArray.toString();
    }

    @RequestMapping("/showDetail")//展示某个问题的详情
    @ResponseBody
    public String showQuestion(HttpServletRequest request, @RequestParam("questID") String questID){
        log.info("查询特定问题详情");
        Question q = questionServiceIMP.getQuestionByQID(questID);
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(q);
        return jsonArray.toString();
    }
    @RequestMapping("/showUserQuestion")//展示某个用户的详情
    @ResponseBody
    public String showUserQuestion(HttpServletRequest request, @RequestParam("userID") String userID){
        log.info("查询特定问题详情");
        List<Question> q = questionServiceIMP.getQuestionByUID(userID);
        JSONArray jsonArray=JSONArray.fromObject(q);
        return jsonArray.toString();
    }

}
