package com.cg.books.dao;


import java.util.Collection;

import com.cg.books.pojo.Books;

public interface BookDao {

	void addBook(Books books);
	
	Collection<Books> viewAllBooks();
	
	Books getBookByName(String bookName);
	
}
