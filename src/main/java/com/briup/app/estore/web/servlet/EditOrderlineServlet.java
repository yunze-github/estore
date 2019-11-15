package com.briup.app.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.shoppingcart.ShoppingCart;

/**
 * Servlet implementation class EditOrderlineServlet
 */
@WebServlet("/updateProduct.action")
public class EditOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//页面的产品ID:productid和产品数量:num
		Integer productId = Integer.parseInt(request.getParameter("productid"));
		Integer num = Integer.parseInt(request.getParameter("num"));
		
		//从session中获取购物车
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
		
		//修改指定产品数量
		shoppingCart.update(productId, num);
		
		//修改后保存购物车到Session
		session.setAttribute("shoppingcart", shoppingCart);
		
		request.getRequestDispatcher("/user/shoppingCart.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
