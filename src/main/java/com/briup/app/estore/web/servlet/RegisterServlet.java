package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ICustomerService customerService = new CustomerServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1 接受请求中携带的参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String zip = request.getParameter("zip");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		
		//2把参数封装为对象
		Customer customer = new Customer(name,password,address,zip,telephone,email);
		
		//3调用service层进行业务处理
		String path = "login.jsp";
		String msg = "注册成功！请登录";
		try {
			/**
			 * 如果方法抛出异常，则注册失败
			 * 如果方法没有抛出异常，这注册处成功
			 */
			customerService.register(customer);
			
		} catch (Exception e) {
			e.printStackTrace();
			path = "register.jsp";
			msg = "注册失败" + e.getMessage();
		}
		
		//4根据service层处理结果，返回合适的页面给浏览器
		request.setAttribute("msg",msg);
		
		response.sendRedirect(path);
	}

}
