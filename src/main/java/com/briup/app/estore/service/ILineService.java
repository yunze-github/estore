package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.shoppingcart.ShoppingCart;

public interface ILineService {

	ShoppingCart addOrderLine(Integer bookId, Customer customer, ShoppingCart shoppingCart)  throws Exception;

	List<Orderline> findOrderlineByOrderId(Integer productId) throws Exception;
	
}
