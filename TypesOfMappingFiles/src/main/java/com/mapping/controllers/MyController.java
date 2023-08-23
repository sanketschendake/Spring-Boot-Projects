package com.mapping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mapping.entites.Book;
import com.mapping.services.BookService;

@Controller
//@RequestMapping("/bookController")
public class MyController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBooks()
	{
		List<Book> books = bookService.getBooks();
		if(books.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getSingleBook(@PathVariable Integer id)
	{
	 	Book book = bookService.getSingleBook(id);
	 	if(book == null)
	 		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	 	return ResponseEntity.of(Optional.of(book));
	 	
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		try {
			bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable Integer id)
	{
		try {
			bookService.updateBook(book, id);
			return ResponseEntity.ok().body(book);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable Integer id)
	{
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/book")
	public String deleteAllBooks()
	{
		bookService.deleteAllBook();
		return "All books deleted";
	}
}
