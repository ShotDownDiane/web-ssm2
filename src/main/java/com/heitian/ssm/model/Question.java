package com.heitian.ssm.model;

/**
 * Created by 53258 on 2017/7/19.
 */
public class Question {
    private String userID;//发起者ID
    private String questionID;//问题ID
    private String title;
    private String text;
    private int pay;
    private String image;
    private String kind;
    private String tag;

    public String getQuestionId() {
        return questionID;
    }

    public void setQuestionId(String id) {
        this.questionID = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String  kind) {
        this.kind = kind;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String  image) {
        this.image = image;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String  tag) {
        this.tag = tag;
    }

}
