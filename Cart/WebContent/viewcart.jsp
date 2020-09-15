<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	table {
		width:500px;
		border-collapse: collapse;
	}
	th{
		padding: 5px;
	}
	#title_table{
		background-color: #0099FF;
		color: white;
	}
</style>
</head>
<body>
	<div align="center">
	<h3>Your  Shopping Cart</h3>
		<c:set var = "shop" value="${sessionScope.SHOP}"></c:set>
			
				<table border="1">
						<tr id="title_table">
							<th>No</th>
							<th>Code</th>
							<th>Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Action</th>	
						</tr>
					<tbody>
					<c:if test="${not empty shop}">
						<form action ="Controller">
							<c:set var = "count" value = "0" />
							<c:forEach var="rows" items="${shop}">
								<c:set var = "count" value = "${count+1}" />
								<tr>
									<th>${count}</th>
									<th>${rows.value.prod.code}</th>
									<th>${rows.value.prod.name}</th>
									<th>${rows.value.prod.price}</th>
									<th>${rows.value.quanty}</th>
									<th><input type="checkbox" name = "rmv" value="${rows.value.prod.code}">
								</tr>
							</c:forEach>
							</c:if>
							<tr>
								<c:url var="add" value="Controller">
										<c:param name="action" value="Addmore"></c:param>
								</c:url>
								<th colspan="5"><a href="${add}">Add more products</a></th>
								<th><input type="submit" name="action" value="Remove"></th>
							</tr>
						</form>
					</tbody>
				</table>
			
	</div>
</body>
</html>










