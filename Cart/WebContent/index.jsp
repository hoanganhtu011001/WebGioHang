<%@page import="util.ProductDB"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	#viewcart{
		background-color: black;
		color: white;
		border: none;
		height: 30px;
	}
	#addtocart{
		background-color: yellow;
		color: black;
		border: none;
	}
	
</style>
</head>
<body>
	<div align="center">
		<h3>Product</h3>
		<table border="1">
			<tr id="title_table">
				<th>No</th>
				<th>Code</th>
				<th>Name</th>
				<th>Price</th>
				<th>Add</th>
			</tr>
			<% 
				List<Product> list = ProductDB.getAll();
				for(Product p : list){%>
				<%
					out.print("<form action=\"Controller\" method=\"post\">"
						+"<tr>"
							+ "<th>" + (list.indexOf(p)+1) + "</th>"
							+ "<th>" + p.getCode() + "</th>"
							+ "<th>" + p.getName() + "</th>"
							+ "<th>" + p.getPrice() + "</th>"
							+ "<input type = \"hidden\"  name =\"txtcode\" value = '"+ p.getCode() +"'/>"
							+ "<input type = \"hidden\"  name =\"txtname\" value = '"+ p.getName() +"'/>"
							+ "<input type = \"hidden\"  name =\"txtprice\" value = '"+ p.getPrice() +"'/>"
							+ "<th><input type = \"submit\" id=\"addtocart\" name =\"action\" value =\"Add To Cart\" /></th>"
						+"</tr>"
						+"</form>"
					);
				%>
			<%}%>
		</table>
		<br>
		<form action="Controller" method="post">
			<input type="submit" id="viewcart" name="action" value="View Cart" />
		</form>
	</div>
</body>
</html>