package com.books.bookapi.mapper;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.books.bookapi.dto.AuthorDto;
import com.books.bookapi.model.Author;

public class AuthorMapper {
	public static Set<Author> mapToEntity(Set<AuthorDto> authorsDto) {

		if (Objects.isNull(authorsDto)) {
			return null;
		}
		return authorsDto.stream().map(authorDto -> {
			Author author = new Author();
			author.setId(authorDto.getId());
			author.setName(authorDto.getName());
			return author;
		}).collect(Collectors.toSet());

	}

	public static Author mapToEntity(AuthorDto authorDto) {

		Author author = new Author();
		author.setId(authorDto.getId());
		author.setName(authorDto.getName());
		return author;

	}
}