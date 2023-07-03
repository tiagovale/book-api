package com.books.bookapi.mapper;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.model.Book;

public class BookMapper {
	public static Book mapToEntity(BookDto dto, Book bookDb) {
		Book book = new Book();
		book.setName(dto.getName());
		book.setAuthors(AuthorMapper.mapToEntity(dto.getAuthorsDto()));
		

		return book;
	}
}