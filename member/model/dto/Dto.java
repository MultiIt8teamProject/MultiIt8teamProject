package com.multi.jdbc.member.model.dto;


import com.recipe.member.dao.MemberDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Dto {
    private int num;
    private String id;
    private String subject;
    private String content;
    private int hitcount;
    private Date created;
    private int grade;


    public Dto(int num, String id, String subject, String content, int hitcount, Date created, int grade) {
        this.num = num;
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.hitcount = hitcount;
        this.created = created;
        this.grade = grade;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getHitcount() {
        return hitcount;
    }

    public void setHitcount(int hitcount) {
        this.hitcount = hitcount;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Dto{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", hitcount=" + hitcount +
                ", created=" + created +
                ", grade=" + grade +
                '}';
    }


}

