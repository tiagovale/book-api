package com.books.bookapi.service;

import java.util.List;

import com.books.bookapi.model.Book;
import com.books.bookapi.repository.BookRepository;

public class BookService implements IBookService {
	private BookRepository bookRepository;

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public void save(Book book) {
		if(book != null && !book.getName().isBlank()){
			try {
				bookRepository.save(book);
			} catch(Exception e) {
				System.out.println("Error message" + e.getMessage());
			}
			
		}
	}

}
