package com.xz2dai.bean;


public class Userbean {

    private String uid;
    private String upwd;
    private String uname;
    private double money;

    public Userbean(String uid, String upwd, String uname, double money) {
        this.uid = uid;
        this.upwd = upwd;
        this.uname = uname;
        this.money = money;
    }
   
    public Userbean() {}
    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
