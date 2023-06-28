package com.books.bookapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.books.bookapi.model.Book;
import com.books.bookapi.repository.BookRepository;

@Service
public class BookService implements IBookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRespository) {
		this.bookRepository = bookRespository;
	}

	@Override
	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	@Override
	public void save(Book book) {
		if (book != null && !Objects.isNull(book.getName())) {
			try {
				bookRepository.save(book);
			} catch (Exception e) {
				System.out.println("Error message" + e.getMessage());
			}

		}
	}

}
