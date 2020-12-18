package com.xz2dai.OA_demo.web.servlet;

import com.xz2dai.OA_demo.bean.UserInfo;
import com.xz2dai.OA_demo.exception.UserInfoException;
import com.xz2dai.OA_demo.service.IUserInfoService;
import com.xz2dai.OA_demo.service.impl.UserInfoServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 处理登录的Servlet
 * 
 * @author yq
 * @date 2020年12月15日
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取表单数据
		// 获取用户名和密码
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		// 2.处理业务逻辑
		IUserInfoService userInfoService = new UserInfoServiceImpl();
		try {
			UserInfo userInfo = userInfoService.login(account, password);
			// userInfo == null：用户名和密码错误
			if (userInfo == null) {
				request.setAttribute("login_error", "用户名或者密码错误...");
				// 请求转发到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("userInfo", userInfo);
				// 登录成功，重定向到首页
				response.sendRedirect(request.getContextPath() + "/system/index/index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 出现异常
			request.setAttribute("login_error", e.getMessage());
			// 请求转发到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		// 通过用户名和密码进行登录
		// 3.分发转向
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用get方式处理代码
		this.doGet(request, response);
	}

}
