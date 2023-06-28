package com.books.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.bookapi.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	Book findByIdOrName(Long id, String name);

}
