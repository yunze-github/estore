package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.service.ICustomerService;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.CustomerServiceImpl;
import com.briup.app.estore.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/user/orderFindAll")
public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ICustomerService customerService = new CustomerServiceImpl();
	private IOrderService orderService = new OrderServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取用户信息
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("user");

		// 将查找完整的用户信息保存到request中
		Customer findCustomer = customerService.findCustomer(customer);

		// 查找完整订单信息
		String msg = "查找用户订单信息成功";
		List<Order> orderList = null;
		try {
			orderList = orderService.findAllOrderByCustomer(findCustomer);
			findCustomer.setOrder(orderList);
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		//用户，用户订单，用户订单详细信息，详细信息中的书籍
		request.getSession().setAttribute("userorder", findCustomer);
		
		response.sendRedirect("order.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
