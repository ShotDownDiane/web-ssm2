package com.heitian.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.heitian.ssm.service.impl.UserServiceIMP;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 53258 on 2017/7/15.
 */
@Controller
@RequestMapping("/doUpload")
public class upload {
    private Logger log = Logger.getLogger(UserController.class);
    @RequestMapping("/show")
    public String show(HttpServletRequest request, HttpServletResponse response){

        return "file";

    }
    @RequestMapping("/one")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException{

        if(!file.isEmpty()){
            String filepath="D:\\fileUpload\\"+file.getOriginalFilename();
            File fileT=new File(filepath);
            FileOutputStream fileO=new FileOutputStream(fileT);
            byte[] ab=file.getBytes();
            try {
                fileO.write(ab);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                fileO.close();
            }
        }else{
            log.info("file isempty");
        }
        return "success";
    }
}
