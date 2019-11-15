package com.briup.app.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.service.IBookService;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService {

	@Override
	public List<Book> findAllBookFromDB() throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSessionFactory().openSession();

		BookMapper mapper = sqlSession.getMapper(BookMapper.class);

		if (mapper == null) {
			throw new Exception("没有库存!");
		}
		return mapper.selectAll();
	}

}
