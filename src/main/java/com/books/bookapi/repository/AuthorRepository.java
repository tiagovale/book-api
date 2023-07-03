package com.books.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.books.bookapi.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
