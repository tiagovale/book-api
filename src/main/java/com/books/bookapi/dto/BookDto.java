package com.books.bookapi.dto;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;

public class BookDto {
	private Long id;

	@NotBlank(message = "The name may not be null!")

	private String name;

	private Set<AuthorDto> authorsDto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<AuthorDto> getAuthorsDto() {
		return authorsDto;
	}

	public void setAuthorDto(Set<AuthorDto> authorsDto) {
		this.authorsDto = authorsDto;
	}
}
