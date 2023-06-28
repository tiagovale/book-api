package com.books.bookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.exception.BookNotFoundException;
import com.books.bookapi.model.Book;
import com.books.bookapi.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getAll() {
		return bookService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody BookDto bookDto) {
		bookService.save(bookDto);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void update(@PathVariable Long id, @RequestBody BookDto bookDto) throws BookNotFoundException {
		bookService.update(id, bookDto);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}
}
