package com.cg.shoopingcart;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.books.pojo.Books;
import com.cg.books.service.BookServiceImp;

@WebServlet("*.app")
public class ShoppingAppController extends HttpServlet {

	BookServiceImp service = new BookServiceImp();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Collection<Books> cartList = service.displayCart();
		session.setAttribute("cartList", cartList);
		session.setAttribute("count", service.getCount());
	
		String action = request.getServletPath();
		System.out.println(action);
		switch (action) {
		case "/refresh.app":
		
			service.addNewBook();

			Collection<Books> book = service.viewAllBooks();
			request.setAttribute("books", book);
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

			break;
			
		case "/addtocart.app":

			String bookName=request.getParameter("bookName");
			service.addBooksToCart(bookName);
			response.sendRedirect("refresh.app");
			break;
			
		case "/cart.app":

			

			cartList.stream().forEach(System.out::println);

			
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("cart.jsp");
			dispatcher1.forward(request, response);
			break;
		case "/delete.app":
			
			String removedBook=request.getParameter("bookName");
			System.out.println(removedBook);
			service.removeFromCart(removedBook);
			service.displayCart();
			response.sendRedirect("cart.app");
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
