package com.mapping.entites;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

// One to One
@Entity
public class Book {

	@Id
	private int id;
	
	private String title;
	
	@OneToOne(cascade = CascadeType.ALL) 	// it creates the author table before the book 
//	@JsonManagedReference	// use for bidirectional mapping one to one mapping
	private Author author;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
}
