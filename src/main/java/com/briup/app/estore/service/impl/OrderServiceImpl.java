package com.briup.app.estore.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Order;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.OrderMapper;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.service.IOrderService;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class OrderServiceImpl implements IOrderService {

	@Override
	public List<Order> findAllOrderByCustomer(Customer customer) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		//拿到用户所有的订单
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		List<Order> orderList = mapper.selectByCustomerId(customer.getId());
		
		if (orderList==null||orderList.size()==0) {
			throw new Exception("用户没有订单信息");
		}
		
		//填充order对象中的orderline
		for (Order order : orderList) {
			List<Orderline> orderLineList = findOrderLineByOrder(order);
			order.setOrderline(orderLineList);
		}
		//返回给Servlet
		return orderList;
	}

	@Override
	public List<Orderline> findOrderLineByOrder(Order order) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		//拿到订单所有的订单详细信息
		OrderlineMapper mapper = sqlSession.getMapper(OrderlineMapper.class);
		List<Orderline> orderLineList = mapper.selectByOrderIdWithBook(order.getId());
		
		/*
		if (orderLineList==null||orderLineList.size()==0) {
			throw new Exception("没有订单详细信息");
		}
		*/
		return orderLineList;
	}

	@Override
	public void saveOrder(Customer customer, ShoppingCart shoppingCart) throws Exception {
		
		//判断购物是否含有商品
		Map<Integer, Orderline> map = shoppingCart.getLines();
		if (map==null||map.size()==0) {
			throw new Exception("用户还没有选购商品!");
		}
		
		//添加此次购物车的订单
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		//构建order订单对象
		Order order = new Order();
		order.setCost(shoppingCart.getCost());
		order.setOrderdate(new Date());
		order.setCustomer(customer);
		
		//添加订单到数据库
		OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
		mapper.insert(order);
		sqlSession.commit();
		
		//同时添加订单详细信息
		System.out.println(order);
		for (Entry<Integer, Orderline> entrySet : map.entrySet()) {
			Orderline orderline = entrySet.getValue();
			orderline.setOrder(order);
			
			//保存订单每一条详细信息
			OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);
			orderlineMapper.insert(orderline);
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteOrderById(Integer productId) throws Exception {
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		//先通过订单id先删除对应的订单明细
		OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);
		int deleteOrderline = orderlineMapper.deleteByOrderId(productId);
		
		if (deleteOrderline==0) {
			throw new Exception("订单明细删除失败!");
		}
		
		OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
		int deleteOrder = orderMapper.deleteByPrimaryKey(productId);
		
		if (deleteOrder==0) {
			throw new Exception("订单删除失败!");
		}
		sqlSession.commit();
	}


	
	
}
