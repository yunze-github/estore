package com.briup.app.estore.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.mapper.BookMapper;
import com.briup.app.estore.util.MyBatisSqlSessionFactory;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		SqlSession openSession = MyBatisSqlSessionFactory.openSession(true);
		BookMapper mapper = openSession.getMapper(BookMapper.class);
		/*
		 * List<Book> selectAll = mapper.selectAll();
		 * selectAll.forEach(System.out::println);
		 */
		Book book = new Book();
		book.setName("Maven入門");
		book.setPrice(46.5);
		System.out.println(book);
		mapper.insert(book);
		System.out.println(book);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
