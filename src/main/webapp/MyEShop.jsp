<%@page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<html>
	<head>
		<meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8";>
		<title>JSP Page</title>
		<style type="text/css">
			#bag{
				text-align: right;
				margin-right: 30px;
				margin-top 30px;
			}	
		</style>
	</head>
	<body>
		<c:set var = "size" value = "${sessionScope.size}"/>
		<p id ="bag"><img src="images/icon.png" width = "50" height = "50"/>
			<a href = "Cart.jsp">Mybag (${size}) items</a></p>	
		<h1>The list of products</h1>
		<form name = "f" action="" method = post>
			Enter the number of items to by:
			<input type = "number" name = "num" value ="1" />
			<hr/>
			<table border = "1px" width = "40%">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var = "p" items = "${sessionScope.list1}">
					<tr>
						<td>${p.id }</td>
						<td>${p.title }</td>
						<td>${p.description }</td>
						<td>
							<input type = "submit" onclick= "buy('${p.id}')" value = "Them vao gio hang"/>
						</td>
					</tr>
				
				</c:forEach>
			</table>
		</form>
	</body>
</html>

<script type = "text/javascript">
	function buy(id){
		document.f.action = "buy?id=" + id;
		document.f.submit();
	}
	
</script>