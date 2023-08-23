package com.mapping.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapping.entites.Book;
import com.mapping.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public List<Book> getBooks()
	{
		return (List<Book>) repo.findAll();
	}
	
	public Book getSingleBook(int id)
	{
		return repo.findById(id);
	}
	
	public Book addBook(Book book)
	{
		return repo.save(book);
	}
	
	public Book updateBook(Book book, int id)
	{
		book.setId(id);
		return repo.save(book);
	}
	
	public void deleteBook(int id)
	{
		repo.deleteById(id);
	}
	
	public void deleteAllBook()
	{
		repo.deleteAll();
	}
}
