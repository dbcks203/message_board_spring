<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="UTF-8"%>
<html>
<head>
	<title>게시물 목록</title>
</head>
<body>
<h1>
	게시물 목록  
</h1>

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
				<td>${item.number}</td>
				<td>${item.title}</td>
				<td>${item.writeid}</td>
				<td>${item.writedate}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>
