package com.springboothello.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int bookId;
	 
	 @Column(name="book_name")
	 private String bookName;
	 
	 @Column(name="auther_name")
	 private String autherName;
	 
	 @Column(name="price")
	 private int price;
	 
	
 
	public String getAutherName() {
		return autherName;
	}
 
	public void setAutherName(String autherName) {
		this.autherName = autherName;
	}
 
	public int getPrice() {
		return price;
	}
 
	public void setPrice(int price) {
		this.price = price;
	}
 
	
 
	public String getBookName() {
		return bookName;
	}
 
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
 
	public int getBookId() {
		return bookId;
	}
 
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book(String bookName, String autherName, int price) {
		super();
		this.bookName = bookName;
		this.autherName = autherName;
		this.price = price;
	}
	 
	 
}
