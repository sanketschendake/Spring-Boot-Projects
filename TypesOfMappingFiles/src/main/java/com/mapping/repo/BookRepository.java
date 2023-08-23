package com.mapping.repo;

import org.springframework.data.repository.CrudRepository;

import com.mapping.entites.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}
