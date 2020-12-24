package com.c611.classProject.dao.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.EmployeeInfo;
import com.c611.classProject.dao.IEmployeeDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class IEmployeeDaoImpl implements IEmployeeDao {

    private QueryRunner run = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public List<EmployeeInfo> getEmployeeListALL() throws SQLException {
        String sql = "select EmployeeName employeeName, EmployeeID employeeID," +
                " EmployeeGender employeeGender," +
                "EmployeeType employeeType,EmployeeMobile employeeMobile from staffs";
        return run.query(sql,new BeanListHandler<EmployeeInfo>(EmployeeInfo.class));

    }

    @Override
    public EmployeeInfo getEmployeeInfoById(String id) throws SQLException {
        String sql = "select  EmployeeName employeeName, EmployeeID employeeID," +
                " EmployeeGender employeeGender,EmployeeType employeeType,EmployeeMobile" +
                " employeeMobile,EmployeeEmail employeeEmail,EmployeeAge employeeAge from staffs where EmployeeID=?";
        return run.query(sql, new BeanHandler<EmployeeInfo>(EmployeeInfo.class),id);

    }

    @Override
    public boolean delEmployeeInfoById(String id) throws SQLException {
        //定义SQL语句
        String sql = "delete from staffs where EmployeeID=?";
        int count = run.update(sql, id);
        return count == 1;
    }

    @Override
    public boolean editEmployeeInfo(EmployeeInfo employeeInfo) throws SQLException{
        //定义SQL语句
        String sql="update staffs set EmployeeName=?,EmployeeGender=?," +
                "EmployeeMobile=?,EmployeeEmail=?,EmployeeAge=?," +
                "EmployeeDescribe=? where EmployeeID=?";
        Object[] params={employeeInfo.getEmployeeName(),
                employeeInfo.getEmployeeGender(),employeeInfo.getEmployeeMobile(),
                employeeInfo.getEmployeeEmail(),employeeInfo.getEmployeeAge(),
                employeeInfo.getEmployeeDescribe(),employeeInfo.getEmployeeID()};
        int count=run.update(sql,params);
        return count==1;

    }


}
