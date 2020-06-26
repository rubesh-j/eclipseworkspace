package com.rubesh.Cucumber;

public class Book {
	public String title;
	public String author;
	
	public Book() {
		
	}
	public String getTitle() {
		return title;
	}
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
