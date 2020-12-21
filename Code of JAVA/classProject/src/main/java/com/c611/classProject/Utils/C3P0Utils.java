package com.c611.classProject.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * 使用C3P0提供数据源的工具类
 *
 * @author yq
 * @date 2020年12月15日
 */
public class C3P0Utils {
	
	// 构建一个C3P0数据源对象
	private static final DataSource dataSource = new ComboPooledDataSource();
	
	private C3P0Utils() {}

	/**
	 * 使用C3P0提供数据源
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

}
