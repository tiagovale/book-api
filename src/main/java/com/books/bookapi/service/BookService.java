package com.books.bookapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.bookapi.dto.BookDto;
import com.books.bookapi.mapper.BookMapper;
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
	@Transactional
	public void save(BookDto bookDto) {
		if (bookDto != null && !Objects.isNull(bookDto.getName())) {
			try {
				Book book = BookMapper.mapToEntity(bookDto);
				bookRepository.save(book);
			} catch (Exception e) {
				System.out.println("Error message" + e.getMessage());
			}

		}
	}
	
	@Override
	public void update(Long id, BookDto bookDto) {
		try {
			 Book book = bookRepository.findById(id)
		                .orElseThrow(() -> new Exception("Book not found"));
		
			if(!Objects.isNull(book)) {
				Book bookUpdated = BookMapper.mapToEntity(bookDto);
				bookUpdated.setId(book.getId());
				bookRepository.save(bookUpdated);
			}
			
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
		
	}
	
	@Override
	@Transactional
	public void delete(BookDto bookDto) {
		try {
			Book book = bookRepository.findByIdOrName(bookDto.getId(), bookDto.getName());
		
			if(!Objects.isNull(book)) {
				bookRepository.delete(book);
			}
			
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}
		
	}

}
