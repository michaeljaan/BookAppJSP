<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}
</style>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body background="C:\Users\acer\Desktop\Anindya\paper.jpg">

	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>

	<div align=right>
		<a href="cart.app">Cart</a> (${sessionScope.count})
	</div>
	<div align=center>
		<h1>Book List</h1>

		<table>
			<tr>
				<th>Cover Page</th>
				<th>Book Name</th>
				<th>Price</th>
				<th>Description</th>
				<th>Author</th>

			</tr>
			<jstl:forEach var="book" items="${requestScope.books }">
				<tr>
					<td><img src="Images/${book.bookImg}" alt="" border=3 height=100 width=100></td>
					<td>${book.bookName}</td>
					<td>${book.price}</td>
					<td>${book.description}</td>
					<td>${book.author}</td>
					<td><a href="addtocart.app?bookName=${book.bookName}">Add
							to Cart</a></td>

				</tr>
			</jstl:forEach>

		</table>



	</div>
	<div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>