<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/style/style.css">

</head>
<body>
	<div class="container2">
	<h1> Expense Details</h1>
	<h4><a href="/travels">Back Home</a></h4>
	<h3> Expense: <c:out value="${oneTravels.expense}" /> </h3>
	<h3> Vendor: <c:out value="${oneTravels.vendor}" /> </h3>
	<h3> Amount: <c:out value="${oneTravels.amount}" /> </h3>
	</div>
	
</body>
</html>