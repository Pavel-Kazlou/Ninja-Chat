<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Sign Up</title>
</head>
<jsp:include page="header.jsp" />
<body><h1>Регистрация</h1>
<form action="${pageContext.request.contextPath}/api/user" method="POST"><p><label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" required></p>
    <p><label for="lastName">Last Name:</label> <input type="text" id="lastName" name="lastName" required></p>
    <p><label for="username">Username:</label> <input type="text" id="username" name="username" required></p>
    <p><label for="password">Password:</label> <input type="password" id="password" name="password" required></p>
    <p><label for="dateOfBirth">Date of Birth:</label> <input type="date" id="dateOfBirth" name="dateOfBirth" required>
    </p>
    <p><input type="submit" value="Отправить"></p></form>
<jsp:include page="footer.jsp" />
</body>
</html>
