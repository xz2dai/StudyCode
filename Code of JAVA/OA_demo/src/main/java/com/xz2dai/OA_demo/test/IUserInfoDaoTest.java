package com.xz2dai.OA_demo.test;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.dao.IUserInfoDao;
import com.xz2dai.OA_demo.dao.impl.UserInfoDaoImpl;
import org.junit.Test;



/**
 * 持久层接口测试
 * 
 * @author Gordon
 * @date 2020年12月15日下午3:55:44
 * @version v12.12
 */
public class IUserInfoDaoTest {
	
	@Test
	public void testSelect() throws Exception {
		// 构建对象
		IUserInfoDao userInfoDao = new UserInfoDaoImpl();
		// 查询
		UserInfo userInfo = userInfoDao.selectByAccountAndPwd("admin", "123456");
		System.out.println(userInfo);
	}

}
