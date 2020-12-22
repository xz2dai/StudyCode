package com.c611.classProject.bean;

import java.util.Date;

/**
 * @author Akili
 * @date 2020/12/19 14:22
 * @software IntelliJ IDEA
 */
public class UserInfo {
    private String userName; //用户名
    private int userID; //用户ID
    private String password; //用户密码
    private Double money;//钱包余额
    private Date creatTime;//账号创建时间
    private String selfIntro;//描述
    private int grade;//用户等级
    private int grand;//用户类型
    private int age;//用户年龄
    private String phoneNum;//手机号
    private String email;//邮箱地址
    private int sex;//性别
    private Date birthday;//生日
    private int state;//状态

    public UserInfo() {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrand() {
        return grand;
    }

    public void setGrand(int grand) {
        this.grand = grand;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }



    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", creatTime=" + creatTime +
                ", selfIntro='" + selfIntro + '\'' +
                ", grade=" + grade +
                ", grand='" + grand + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", brithday=" + birthday +
                ", state=" + state +
                '}';
    }


}
