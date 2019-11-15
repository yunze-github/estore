package com.briup.app.estore.web.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.briup.app.estore.bean.Book;
import com.briup.app.estore.service.IBookService;
import com.briup.app.estore.service.impl.BookServiceImpl;

/**
 * Servlet Filter implementation class VisitBooksInIndexFilter
 */
@WebFilter("/index.jsp")
public class VisitBooksInIndexFilter implements Filter {
	
	private IBookService bookService = new BookServiceImpl();

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		String msg = "显示库存";
		try {
			
			List<Book> booksFromDB = bookService.findAllBookFromDB();
			
			//将库存书籍保存到application中
			request.getServletContext().setAttribute("booksFromDB", booksFromDB);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = e.getMessage();
		}
		request.setAttribute("msg", msg);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
