package com.books.bookapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.model.Book;
import com.books.bookapi.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

	private BookService bookService;

	@Mock
	private List<Book> books;

	@Mock
	private BookRepository bookRepository;

	@BeforeEach
	public void setUp() {
		Book book = new Book();
		book.setName("teste");

		Book book2 = new Book();
		book2.setName("teste2");

		books.add(book);
		books.add(book2);

		bookService = new BookService(bookRepository);
	}

	@Test
	public void getAllSuccessTest() {
		when(bookRepository.findAll()).thenReturn(books);
		assertEquals(books.size(),bookService.getAll().size());
	}

	@Test
	public void saveSuccessTest() {
		BookDto book = new BookDto();
		book.setName("teste");

		bookService.save(book);

		verify(bookRepository).save(any());

	}

	@Test
	public void saveFailTest() {
		BookDto bookDto = new BookDto();

		bookService.save(bookDto);

		verify(bookRepository, never()).save(any());

	}

}
