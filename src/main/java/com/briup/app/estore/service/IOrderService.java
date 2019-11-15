package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;

public interface IOrderService {

	// 查找该用户数据库订单信息
	List<Order> findAllOrderByCustomer(Customer customer) throws Exception;

	// 查找该用户数据库订单明细信息
	List<Orderline> findOrderLineByOrder(Order order) throws Exception;

	void saveOrder(Customer customer, ShoppingCart shoppingCart) throws Exception;

	void deleteOrderById(Integer productId) throws Exception;

}
