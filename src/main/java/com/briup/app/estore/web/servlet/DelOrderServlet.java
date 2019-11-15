package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class DelOrderServlet
 */
@WebServlet("/user/orderRemove")
public class DelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IOrderService orderService = new OrderServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//获取页面订单id
		Integer productId = Integer.parseInt(request.getParameter("id"));
		
		//删除订单id
		String msg = "删除订单成功!";
		try {
			orderService.deleteOrderById(productId);
		} catch (Exception e) {
			msg = e.getMessage();
			e.printStackTrace();
		}
		
		request.setAttribute("msg", msg);
		response.sendRedirect("orderFindAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
