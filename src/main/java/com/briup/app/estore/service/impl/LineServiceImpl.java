package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Customer;
import com.briup.app.estore.bean.Orderline;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.mapper.OrderlineMapper;
import com.briup.app.estore.service.ILineService;
import com.briup.app.estore.shoppingcart.ShoppingCart;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class LineServiceImpl implements ILineService {

	@Override
	public ShoppingCart addOrderLine
		(Integer bookId, Customer customer, ShoppingCart shoppingCart) throws Exception {

		SqlSession sqlSession = 
				MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		// 查询index.jsp的bookId对应book
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		Book book = mapper.selectByPrimaryKey(bookId);

		// 构建OrderLine
		Orderline orderline = new Orderline();
		orderline.setNum(1);
		orderline.setBook(book);
		
		// HttpSession中的购物车添加	订单信息
		shoppingCart.add(orderline);
		
		return shoppingCart;
	}

	@Override
	public List<Orderline> findOrderlineByOrderId(Integer productId) throws Exception {
		
		SqlSession sqlSession = 
				MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();
		
		OrderlineMapper mapper = sqlSession.getMapper(OrderlineMapper.class);
		
		return mapper.selectByOrderIdWithBook(productId);
	}

}
