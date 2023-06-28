package com.books.bookapi.service;

import java.util.List;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.exception.BookNotFoundException;
import com.books.bookapi.model.Book;

public interface IBookService {

	public List<Book> getAll();
	public void save(BookDto book);
	public void update(Long id, BookDto bookDto) throws BookNotFoundException;
	public void delete(Long id);
	
}
