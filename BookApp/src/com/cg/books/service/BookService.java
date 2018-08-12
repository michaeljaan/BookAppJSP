package com.cg.books.service;

import java.util.Collection;

import com.cg.books.pojo.Books;

public interface BookService {
	
	public void addNewBook();

	public Collection<Books> viewAllBooks();

 	public Books getBookByName(String bookName);


}
