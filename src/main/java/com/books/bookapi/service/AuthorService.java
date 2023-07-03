package com.books.bookapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.books.bookapi.dto.AuthorDto;
import com.books.bookapi.mapper.AuthorMapper;
import com.books.bookapi.model.Author;
import com.books.bookapi.repository.AuthorRepository;

@Service
public class AuthorService implements IAuthorService {

	private final AuthorRepository authorRepository;

	public AuthorService( AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> getAll() {
		return authorRepository.findAll();
	}

	@Override
	@Transactional
	public void save(AuthorDto authorDto) {
		try {
			Author author = AuthorMapper.mapToEntity(authorDto);
			authorRepository.save(author);
		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}

	}

	@Override
	public void update(Long id, AuthorDto authorDto) throws Exception {

		Author author = authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found"));

		Author authorToUpdate = AuthorMapper.mapToEntity(authorDto);
		authorToUpdate.setId(author.getId());
		authorRepository.save(authorToUpdate);

	}

	@Override
	@Transactional
	public void delete(Long authorId) {
		try {
			Optional<Author> author = authorRepository.findById(authorId);

			if (author.isPresent()) {
				authorRepository.delete(author.get());
			}

		} catch (Exception e) {
			System.out.println("Error message" + e.getMessage());
		}

	}

}
