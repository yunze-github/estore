package com.briup.app.estore.service;

import java.util.List;

import com.briup.app.estore.bean.Book;

public interface IBookService {
	
	List<Book> findAllBookFromDB() throws Exception;

}
