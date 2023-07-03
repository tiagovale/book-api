package com.books.bookapi.service;

import java.util.List;

import com.books.bookapi.dto.AuthorDto;
import com.books.bookapi.model.Author;

public interface IAuthorService {

	public List<Author> getAll();
	public void save(AuthorDto authorDto);
	public void update(Long id, AuthorDto authorDto) throws Exception;
	public void delete(Long id);
	
}
