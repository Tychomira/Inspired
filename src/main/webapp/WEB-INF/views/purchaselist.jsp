<%-- 
    Document   : purchaselist
    Created on : 07-May-2020, 13:37:33
    Author     : mac
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>purchases' List</title>
    </head>
    <body>
        <h1>purchases' List</h1>
        <table>
		<tr>
                    <td>ID</td><td>Purchase id</td><td>Date</td>
		</tr>
		<c:forEach items="${purchases}" var="purchase">
			<tr>
                           

                            <td>${purchase.id}</td>
                            <td>${purchase.date}</td>
                          
                            
			</tr>
		</c:forEach>
	</table>
    </body>
</html>
