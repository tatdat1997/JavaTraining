package com.springboothello.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboothello.entity.Book;
import com.springboothello.entity.Student;
import com.springboothello.entity.StudentInfo;
import com.springboothello.repositories.StudentInfoRepository;
import com.springboothello.service.BookService;
import com.springboothello.service.StudentInfoService;
import com.springboothello.serviceImpl.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
 
	@Autowired
	private StudentInfoService studentInfoRepo;
	
	@RequestMapping(value = "/savebook")
    public Book saveBook() {
		Book book = new Book("Harry Potter", "JK. Rowling", 1200000);
		bookService.saveBook(book);;
		return book;
	}
	
	@RequestMapping(value = "/teststudent")
	 public StudentInfo testStudent() {
		StudentInfo A = new StudentInfo(new Student("Test Student", "123@zxc"),
				"LA", 9.35, "1999-12-12");
		studentInfoRepo.saveStudent(A);
		return A;
	}
}
