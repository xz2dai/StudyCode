package com.c611.classProject.bean;

/**
 * @author llz
 * @version 1.0
 * @date 2020/12/20 18:47
 */
public class Orders {
        private int OrderID;
        private int OrderUserID;
        private int OrdergoodID;
        private String OrderDescribe;

        public Orders(){

        }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getOrderUserID() {
        return OrderUserID;
    }

    public void setOrderUserID(int orderUserID) {
        OrderUserID = orderUserID;
    }

    public int getOrdergoodID() {
        return OrdergoodID;
    }

    public void setOrdergoodID(int ordergoodID) {
        OrdergoodID = ordergoodID;
    }

    public String getOrderDescribe() {
        return OrderDescribe;
    }

    public void setOrderDescribe(String orderDescribe) {
        OrderDescribe = orderDescribe;
    }
}
