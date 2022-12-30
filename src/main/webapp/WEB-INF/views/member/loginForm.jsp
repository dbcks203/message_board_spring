<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form name="loginForm" id="loginForm" action="login.do" method="post">
	아이디 : <input type="text" name="uid" /><br/>
	비밀번호 : <input type="password" name="pwd" /><br/>
	<input type="submit" value="로그인" />
	<input type="reset" value="초기화" />
</form>
