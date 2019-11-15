package com.briup.app.estore.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;

/**
 * Servlet Filter implementation class UserInfoFilter
 */
@WebFilter("/user/userinfo.jsp")
public class UserInfoFilter implements Filter {
	
	private ICustomerService customerService = new CustomerServiceImpl();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		//获取session中用户user
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("user");
		
		//调用service查找用信息返回给界面
		Customer findCustomer = customerService.findCustomer(customer);
		
		req.setAttribute("userinfo", findCustomer);
		
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
