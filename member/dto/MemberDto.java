package com.recipe.member.dto;

import java.util.Date;

public class MemberDto {

    private int no;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String tel;
    private Date signupDate;
    private Date deleteAccountDate;
    private int grade;
    private String deleteAccount;
    public MemberDto(){

    }

    public MemberDto(String id, String pw, String name, String gender, String tel) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.tel = tel;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getSignupDate() {
        return signupDate;
    }

    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    public Date getDeleteAccountDate() {
        return deleteAccountDate;
    }

    public void setDeleteAccountDate(Date deleteAccountDate) {
        this.deleteAccountDate = deleteAccountDate;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDeleteAccount() {
        return deleteAccount;
    }

    public void setDeleteAccount(String deleteAccount) {
        this.deleteAccount = deleteAccount;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "no=" + no +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                ", signupDate=" + signupDate +
                ", deleteAccountDate=" + deleteAccountDate +
                ", grade=" + grade +
                ", deleteAccount='" + deleteAccount + '\'' +
                '}';
    }
}
