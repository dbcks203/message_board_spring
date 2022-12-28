<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>게시물번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${boardList}">
			<tr>
				<td>${item.seq}</td>
				<td>${item.subject}</td>
				<td>${item.userId}</td>
				<td>${item.regDate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>