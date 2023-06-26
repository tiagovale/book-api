package com.books.bookapi.service;

import java.util.List;
import com.books.bookapi.model.Book;

public interface IBookService {

	public List<Book> getAll();
	public void save(Book book);
	
}
