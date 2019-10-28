package com.springboothello.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboothello.entity.Book;
import com.springboothello.repositories.BookRepository;
import com.springboothello.service.BookService;


 
@Service
public class BookServiceImpl implements BookService {
 
	@Autowired
	private BookRepository bookRepository;
 
 
 
 

	@Transactional(rollbackFor = {RuntimeException.class})
	public void saveBook(Book book) {
 
		Book book1 = null;
		// save book
		book1 = bookRepository.save(book);
		Integer.parseInt("");
	}



 
}
