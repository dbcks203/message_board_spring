<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false"  pageEncoding="UTF-8"%>
<html>
<head>
	<title>회원 관리 목록</title>
</head>
<body>
<h1>
	회원 관리 목록  
</h1>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${list}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td><a href="<c:url value='/member/view.do?uid=${item.uid}'/>">${item.uid}</a></td>
				<td>${item.pwd}</td>
				<td>${item.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>
