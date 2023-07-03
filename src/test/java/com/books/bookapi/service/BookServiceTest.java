package com.books.bookapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.books.bookapi.dto.AuthorDto;
import com.books.bookapi.dto.BookDto;
import com.books.bookapi.exception.AuthorNotFoundException;
import com.books.bookapi.exception.BookNotFoundException;
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
		BookDto bookDto = getBookWithAuthor();

		bookService.save(bookDto);

		verify(bookRepository).save(any());

	}

	@Test
	public void saveFailTest() {

		AuthorNotFoundException thrown = Assertions.assertThrows(AuthorNotFoundException.class, () -> {
			bookService.save(new BookDto());
		});

		Assertions.assertEquals("Author not found", thrown.getMessage());
	}

	@Test
	public void updateSuccessTest() throws BookNotFoundException {
		Book bookDb = new Book();
		bookDb.setId(1L);
		bookDb.setName("movie1");

		BookDto bookDto = new BookDto();
		bookDto.setName("better movie");

		when(bookRepository.findById(1L)).thenReturn(Optional.of(bookDb));

		bookService.update(1L, bookDto);

		verify(bookRepository).save(any());

	}

	@Test
	public void updateFailTest() throws BookNotFoundException {

		BookNotFoundException thrown = Assertions.assertThrows(BookNotFoundException.class, () -> {
			bookService.update(1L, new BookDto());
		});

		Assertions.assertEquals("Book not found", thrown.getMessage());

	}

	private BookDto getBookWithAuthor() {
		BookDto book = new BookDto();
		book.setName("teste");

		HashSet<AuthorDto> authors = new HashSet<AuthorDto>();

		AuthorDto authorDto = new AuthorDto();
		authorDto.setName("name");
		authors.add(authorDto);

		book.setAuthorDto(authors);
		return book;
	}

}
