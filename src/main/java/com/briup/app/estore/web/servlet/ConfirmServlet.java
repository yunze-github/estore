package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.OrderServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/user/orderSave")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//获取session的购物车
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
		
		//获取当前用户
		Customer customer = (Customer) session.getAttribute("user");
		
		//保存用户购物车订单
		String msg = "保存订单成功!";
		String path = "/index.jsp";
		try {
			orderService.saveOrder(customer, shoppingCart);
		} catch (Exception e) {
			msg = e.getMessage();
			path = "/user/confirmOrder.jsp";
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		response.sendRedirect(path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
