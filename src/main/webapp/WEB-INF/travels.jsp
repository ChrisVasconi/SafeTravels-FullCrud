<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style/style.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<form:form action="/travels" method="post" modelAttribute="travels">
	<div class="container">
		<table>
			<thead>
				<tr>
					<th> Expense: </th>
					<th> Vendor: </th>
					<th> Amount: </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachTravels" items="${travelsList}">
					<tr> 
						<td><a href="/travels/${eachTravels.id}"> ${eachTravels.expense} </td>
						<td> ${eachTravels.vendor} </td>
						<td> ${eachTravels.amount} </td>
						<td> <a href="travels/edit/${eachTravels.id}">Edit</a></td>
						<td>
							<form action="/travels/${eachTravels.id}" method="post">
							<input type="hidden" name="_method" value="delete" />
							<button type="submit"> Delete </button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</form:form>
	<div class="cont">
		
		<form:form action="/travels" method="post" modelAttribute="newTravel">
		<h2>Add an Expense!</h2>
		<h3>
			<form:label path="expense"> Expense Name: </form:label>
			<br><form:input type="text" path="expense"/>
			<form:errors path="expense" />
		</h3>
		<h3>
			<form:label path="vendor"> Vendor: </form:label>
			<br><form:input type="text" path="vendor"/>
			<form:errors path="vendor" />
		</h3>
		<h3>
			<form:label path="amount"> Amount: </form:label>
			<br><form:input type="number" path="amount"/>
			<form:errors path="amount" />
		</h3>
		<h3>
			Description:
			<br><form:textarea path="description"/>
			<form:errors path="description" />
			<br><button class="button" type="submit">Submit!</button>
		</h3>
	</form:form>
	</div>
</body>
</html>