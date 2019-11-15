package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.impl.LineServiceImpl;
import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class AddOrderlineServlet
 */
@WebServlet("/user/addOrderline")
public class AddOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ILineService lineService = new LineServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Integer bookId = Integer.parseInt(request.getParameter("bookid"));
		
		HttpSession session = request.getSession();
		//获取session用户名
		Customer customer = (Customer) session.getAttribute("user");
		
		//获取Session中的shoppingcart
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
		
		ShoppingCart shoppingCartAdded;
		try {
			shoppingCartAdded = lineService.addOrderLine(bookId, customer, shoppingCart);
			
			//购物车添加商品过后，重新添加购物车到Session中1
			session.setAttribute("shoppingcart", shoppingCartAdded);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("shoppingCart.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
