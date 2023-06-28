package com.books.bookapi.mapper;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.model.Book;

public class BookMapper {
    public static Book mapToEntity(BookDto dto) {
        Book book = new Book();
        book.setName(dto.getName());
    
        return book;
    }
}