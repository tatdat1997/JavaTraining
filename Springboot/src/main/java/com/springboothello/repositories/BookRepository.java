package com.springboothello.repositories;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
 
import org.springframework.stereotype.Repository;

import com.springboothello.entity.Book;

 
@Repository
public interface BookRepository extends CrudRepository<Book,Serializable> {
		
}