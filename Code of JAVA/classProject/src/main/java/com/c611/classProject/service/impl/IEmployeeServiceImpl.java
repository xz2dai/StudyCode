package com.c611.classProject.service.impl;

import com.c611.classProject.Utils.C3P0Utils;
import com.c611.classProject.bean.EmployeeInfo;
import com.c611.classProject.dao.IEmployeeDao;
import com.c611.classProject.dao.impl.IEmployeeDaoImpl;
import com.c611.classProject.exception.EmployeeInfoException;
import com.c611.classProject.service.IEmployeeService;
import java.sql.SQLException;
import java.util.List;

public class IEmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDao IEmployeeDao = new IEmployeeDaoImpl();

    @Override
    public List<EmployeeInfo> getEmployeeListALL() throws EmployeeInfoException {

        try {
            return IEmployeeDao.getEmployeeListALL();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeInfoException("查询所有员工信息失败");
        }
    }

    @Override
    public EmployeeInfo getEmployeeInfoById(String employeeId) throws EmployeeInfoException {
        try {
            return IEmployeeDao.getEmployeeInfoById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeInfoException("通过id查询员工信息失败...");
        }
    }

    @Override
    public boolean delEmployeeInfoById(String employeeId) throws EmployeeInfoException {
        try {
            return IEmployeeDao.delEmployeeInfoById(employeeId);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeInfoException("通过id删除员工信息失败...");
        }
    }

    @Override
    public boolean editEmployeeInfo(EmployeeInfo EmployeeInfo) throws EmployeeInfoException {
        try {
            return IEmployeeDao.editEmployeeInfo(EmployeeInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeInfoException("通过id编辑员工信息失败...");
        }
    }
}
