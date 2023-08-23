package com.mapping.entites;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


// One to one bidirectional
@Entity
public class Author {
	
	@Id
	private int authorId;
	
	private String fname;
	
	private String lname;
	
//	@OneToOne(mappedBy = "author")
//	@JoinColumn(name = "book_id")	// change the column name of foreign key column
//	@JsonBackReference
	private Book book;

	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
}
