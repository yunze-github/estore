package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICustomerService customerService = new CustomerServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取登录信息参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		// 将登录信息封装为对象
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);

		// 调用service层进行用户登录判断
		String path = "index.jsp";
		String msg = customer.getName() + "成功登录!";
		try {
			customerService.login(customer);
			
			HttpSession session = request.getSession();
			
			//保存用户到session中
			Customer findCustomer = customerService.findCustomer(customer);
			session.setAttribute("user", findCustomer);
			
			//创建购物车保存到session中
			ShoppingCart shoppingCart = new ShoppingCart();
			session.setAttribute("shoppingcart", shoppingCart);
			
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage().contains("用户不存在")) {
				path = "register.jsp";
			}
			if (e.getMessage().contains("密码错误")) {
				path = "login.jsp";
			}
			msg = e.getMessage();
		}
		request.setAttribute("msg", msg);
		
		response.sendRedirect(path);
	}

}
