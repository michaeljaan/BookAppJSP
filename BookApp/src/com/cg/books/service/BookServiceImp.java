package com.cg.books.service;

import java.util.Collection;

import com.cg.book.cart.CartList;
import com.cg.books.dao.BookDao;
import com.cg.books.dao.BookDaoImp;
import com.cg.books.pojo.Books;

public class BookServiceImp implements BookService{

	private BookDao dao = new BookDaoImp();
	private CartList cart= new CartList();
	
	@Override
	public void addNewBook() {
		dao.addBook(new Books("Fedegraphica",500,1," A Graphic Biography of the Genius of Roger Federer","Mark Hodgkinson ","RogerFederer.jpg"));	

		dao.addBook(new Books("Rafa",350,1," Paperback","Rafael Nadal ","rafaelnadal.jpg"));	

		dao.addBook(new Books("Roger Federer and Rafael Nadal",600,1,"Roger Federer and Rafael Nadal","Sebastián Fest","fedal.jpg"));	

		dao.addBook(new Books("The Circuit",500,1,"A Tennis Odyssey","Rowan Ricardo Phillips ","thecircuit.jpg"));	

		dao.addBook(new Books("The LOST Chronicles",700,1,"Hardcove","Mark Cotta Vaz","lost.jpg"));	

	}

	@Override
	public Collection<Books> viewAllBooks() {
		
		return dao.viewAllBooks();
	}

	@Override
	public Books getBookByName(String bookName) {
		
		return dao.getBookByName(bookName);
	}
	
	public void addBooksToCart(String bookName)
	{
		
		cart.addBookToCart(bookName);
	}

	public Collection<Books> displayCart() {
		
		return cart.displayCart();
	}

	public void removeFromCart(String removedBook) {
		
		cart.removeFromCart(removedBook);
	}

	public int getCount()
	{
		return cart.getCount();
	}
}
