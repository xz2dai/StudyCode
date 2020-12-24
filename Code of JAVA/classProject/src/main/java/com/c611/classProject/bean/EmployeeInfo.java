package com.c611.classProject.bean;

import java.io.Serializable;

public class EmployeeInfo implements Serializable {
    private int employeeID;      //员工ID
    private String  employeeName;//姓名
    private int employeeGender;  //性别
    private int employeeAge;     //年龄
    private int employeeType;    //类型
    private String employeeMobile;  //电话
    private String employeeEmail;   //邮箱
    private String employeeDescribe;//简介
    public EmployeeInfo(){

    }

    public EmployeeInfo(int employeeID,
                        String employeeName,
                        int employeeGender,
                        int employeeAge,
                        int employeeType,
                        String employeeDescribe,
                        String employeeMobile,
                        String employeeEmail) {

        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeGender = employeeGender;
        this.employeeAge = employeeAge;
        this.employeeType = employeeType;
        this.employeeEmail = employeeEmail;
        this.employeeMobile = employeeMobile;
        this.employeeDescribe = employeeDescribe;


    }

    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getEmployeeGender() { return employeeGender; }
    public void setEmployeeGender(int employeeGender) { this.employeeGender = employeeGender; }

    public int getEmployeeAge() {return employeeAge; }
    public void setEmployeeAge(int employeeAge) { this.employeeAge = employeeAge; }

    public int getEmployeeType() { return employeeType; }
    public void setEmployeeType(int employeeType) { this.employeeType = employeeType; }

    public String getEmployeeEmail() { return employeeEmail; }
    public void setEmployeeEmail(String employeeEmail) { this.employeeEmail = employeeEmail; }

    public String getEmployeeDescribe() { return employeeDescribe; }
    public void setEmployeeDescribe(String employeeDescribe) { this.employeeDescribe = employeeDescribe; }

    public String getEmployeeMobile() { return employeeMobile; }
    public void setEmployeeMobile(String employeeMobile) { this.employeeMobile = employeeMobile; }


    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeGender=" + employeeGender +
                ", employeeAge=" + employeeAge +
                ", employeeType=" + employeeType +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeDescribe='" + employeeDescribe + '\'' +
                ", employeeMobile='" + employeeMobile + '\'' +
                '}';
    }
}


