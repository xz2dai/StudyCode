package com.xz2dai.bean;

public class ParkingOrder {
    private int id;     //订单id
    private int number;     //订单编号
    private String startTime;  //开始时间
    private String finisherTime;    //结束时间
    private int money;      //金额
    private String date;    //日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinisherTime() {
        return finisherTime;
    }

    public void setFinisherTime(String finisherTime) {
        this.finisherTime = finisherTime;
    }
}
