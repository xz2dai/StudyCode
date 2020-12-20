package com.c611.classProject.bean;

import javax.naming.Name;
import java.lang.reflect.Type;

/**
 * @author ：yq
 * @description：商品bean
 * @date ：2020/12/20 21:30
 */public class Goods {
    private int GoodID;
    private String GoodName;
    private double GoodPrice;
    private String GoodDescribe;
    private int GoodStatus;
    private int GoodType;

    public Goods(){

    }

    public Goods(int id,String name,double price,String goodDescribe,int goodStatus,int goodType){
        this.GoodID = id;
        this.GoodName = name;
        this.GoodPrice = price;
        this.GoodDescribe = goodDescribe;
        this.GoodStatus = goodStatus;
        this.GoodType = goodType;
    }

    public Goods(String goodName,double goodPrice){
        this.GoodID = 100;
        this.GoodName = goodName;
        this.GoodPrice = goodPrice;
        this.GoodDescribe = "";
        this.GoodStatus = 1;
        this.GoodType = 1;
    }

    public int getGoodID() {
        return GoodID;
    }

    public void setGoodID(int goodID) {
        GoodID = goodID;
    }

    public String getGoodName() {
        return GoodName;
    }

    public void setGoodName(String goodName) {
        GoodName = goodName;
    }

    public double getGoodPrice() {
        return GoodPrice;
    }

    public void setGoodPrice(double goodPrice) {
        GoodPrice = goodPrice;
    }


    public String getGoodDescribe() {
        return GoodDescribe;
    }

    public void setGoodDescribe(String goodDescribe) {
        GoodDescribe = goodDescribe;
    }

    public int getGoodStatus() {
        return GoodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        GoodStatus = goodStatus;
    }

    public int getGoodType() {
        return GoodType;
    }

    public void setGoodType(int goodType) {
        GoodType = goodType;
    }
}
