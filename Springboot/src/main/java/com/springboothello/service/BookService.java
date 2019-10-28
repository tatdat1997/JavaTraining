package com.springboothello.service;


import org.springframework.stereotype.Component;

import com.springboothello.entity.Book;
 
@Component
public interface BookService {
	public void saveBook(Book book);
	
 
}
