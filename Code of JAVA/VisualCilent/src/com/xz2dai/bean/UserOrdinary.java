package com.xz2dai.bean;

public class UserOrdinary {
    private int id;     //用户id
    private String accountNum;      //账号
    private  String password;       //登陆密码
    private int phoneNum;       //电话号码
    private int gender;     //性别
    private int score;      //信誉积分
    private String carNum;      //车牌号码
    private String idNum;       //身份证号
    private int iden;       //认证标识
    private String parkSpaceNum;        //停车位号码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setLicenseNum(String carNum) {
        this.carNum = carNum;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public int getIden() {
        return iden;
    }

    public void setIden(int iden) {
        this.iden = iden;
    }

    public String getParkSpaceNum() {
        return parkSpaceNum;
    }

    public void setParkSpaceNum(String parkSpaceNum) {
        this.parkSpaceNum = parkSpaceNum;
    }
}
