package com.c611.classProject.service;

import com.c611.classProject.bean.EmployeeInfo;
import com.c611.classProject.exception.EmployeeInfoException;
import java.util.List;

public interface IEmployeeService {

    List<EmployeeInfo> getEmployeeListALL() throws EmployeeInfoException;

    EmployeeInfo getEmployeeInfoById(String employeeId) throws EmployeeInfoException;

    boolean delEmployeeInfoById(String employeeId) throws EmployeeInfoException;

    boolean editEmployeeInfo(EmployeeInfo EmployeeInfo) throws EmployeeInfoException;
}

/*
public interface IUserService {

    List<UserInfo> findAll() throws UserInfoException;

    UserInfo getUserInfoById(String userId) throws UserInfoException;

    boolean delUserInfoById(String userId) throws UserInfoException;

    boolean editUserInfo(UserInfo userInfo) throws UserInfoException;
}

*/