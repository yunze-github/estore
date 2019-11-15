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
 * Servlet implementation class DelOrderlineServlet
 */
@WebServlet("/removeProduct.action")
public class DelOrderlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获得页面的productid产品ID
		Integer productId = Integer.parseInt(request.getParameter("productid"));
		
		//获取Session中购物车对象
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingcart");
		
		//删除指定产品
		shoppingCart.delete(productId);
		
		//删除过后保存购物车到Session中
		//session.setAttribute("shoppingcart", shoppingCart);
		
		request.getRequestDispatcher("/user/shoppingCart.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
