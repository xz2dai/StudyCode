package com.xz2dai.OA_demo.web.servlet;


import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.exception.UserInfoException;
import com.xz2dai.OA_demo.service.IUserInfoService;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 通过id查询用户信息
 * 
 * @author Gordon
 * @date 2020年12月17日下午5:04:08
 * @version v12.12
 */
@WebServlet("/getUserInfoById")
public class GetUserInfoByIdServlet extends HttpServlet {

	private static final long serialVersionUID = 1905824258970769556L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取表单数据
		String id = request.getParameter("id");
		// 2.处理业务逻辑
		IUserInfoService userInfoService = new UserInfoServiceImpl();
		try {
			// 调用通过id查询用户信息的方法
			UserInfo userInfo = userInfoService.findUserByID(id);
			// 3.分发转向
			// 保存用户数据
			request.setAttribute("userInfo", userInfo);
			// 请求转发到显示用户信息数据的页面
			request.getRequestDispatcher("/system/userInfo.jsp").forward(request, response);
		} catch (UserInfoException | SQLException e) {
			e.printStackTrace();
		}


	}

}
