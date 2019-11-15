package com.briup.app.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.service.impl.LineServiceImpl;

/**
 * Servlet implementation class OrderinfoServlet
 */
@WebServlet("/user/orderInfo")
public class OrderinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ILineService lineService = new LineServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 获取页面的订单id
		Integer productId = Integer.parseInt(request.getParameter("id"));

		// 调用service层查找订单明细
		List<Orderline> lines = null;
		try {
			lines = lineService.findOrderlineByOrderId(productId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 该用户所有订单总价
		Double totalCost = 0.0;
		for (Orderline orderline : lines) {
			totalCost+=orderline.getNum()*orderline.getBook().getPrice();
		}
		HttpSession session = request.getSession();
		session.setAttribute("totalcost", totalCost);
		session.setAttribute("userlines", lines);

		response.sendRedirect("orderinfo.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
