package com.c611.classProject.bean;

/**
 * 订单实体类
 * @author llz
 * @version 1.0
 * @date 2020/12/20 18:47
 */
public class Orders {
        private int OrderID;
        private int OrderUserID;
        private int OrdergoodID;
        private String OrderDescribe;
        private int OrderStatus;

        public Orders(){

        }

    public Orders(int orderID, int orderUserID, int ordergoodID, String orderDescribe, int orderStatus) {
        OrderID = orderID;
        OrderUserID = orderUserID;
        OrdergoodID = ordergoodID;
        OrderDescribe = orderDescribe;
        OrderStatus = orderStatus;
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

    public int getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        OrderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrderID=" + OrderID +
                ", OrderUserID=" + OrderUserID +
                ", OrdergoodID=" + OrdergoodID +
                ", OrderDescribe='" + OrderDescribe + '\'' +
                ", OrderStatus=" + OrderStatus +
                '}';
    }
}
