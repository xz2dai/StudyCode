package net.hunau.goodsmanager.utils;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * 数据库操作工具类
 */
public class JDBCUtils {
	
	public static DataSource ds = null;
	// 初始化C3P0数据源
	static {
		try {
			Properties prop = new Properties();
			InputStream in = JDBCUtils.class.getClassLoader()
					.getResourceAsStream("dbcpconfig.properties");
			prop.load(in);
			ds = BasicDataSourceFactory.createDataSource(prop);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 加载驱动，并建立数据库连接
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		return ds.getConnection();
	}
	// 关闭数据库连接，释放资源
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
     public static void release(ResultSet rs, Statement stmt, 
     		Connection conn){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}
}
