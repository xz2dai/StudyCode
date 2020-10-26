package com.xz2dai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static final String URL = "jdbc:mysql://101.133.235.230:3306/testdb?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER = "root";
    public static final String PASSWORD = "awcid2000";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection ct = DriverManager.getConnection(URL,USER,PASSWORD);
        Statement stmt = ct.createStatement();
        ResultSet re = stmt.executeQuery("select * from testtable1");
        while (re.next()){
            System.out.println(re.getString("id")+":"+re.getString("name"));
        }
        ct.close();
    }
}
