package com.c611.classProject.dao;

import com.c611.classProject.bean.EmployeeInfo;
import java.sql.SQLException;
import java.util.List;

public interface IEmployeeDao {


    List<EmployeeInfo> getEmployeeListALL() throws SQLException;

    EmployeeInfo getEmployeeInfoById(String id) throws SQLException;

    boolean delEmployeeInfoById(String id) throws SQLException;

    boolean editEmployeeInfo(EmployeeInfo employeeInfo) throws SQLException;




}