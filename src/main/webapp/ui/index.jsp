<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Вход и регистрация</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/css/style.css">
</head>
<style>
    img {
        width: 100%;
        max-width: 100%;
    }
</style>
<body>
<c:choose>
    <c:when test="${not empty user}">
        <jsp:include page="header.jsp" />
        <div class="container">
            <img src="${pageContext.request.contextPath}/ui/images/homeImage1.jpg" alt="ninjaTurtles">
        </div>
    </c:when>
    <c:otherwise>
        <jsp:include page="header.jsp" />
        <div class="container">
            <img src="${pageContext.request.contextPath}/ui/images/homeImage1.jpg" alt="ninjaTurtles">
        </div>
        <main>
            <div class="welcome">
                <h2>Добро пожаловать в чат истинных Нииииндзя!</h2>
                <p>Ниндзя - это не просто профессия, это образ жизни. Ведь когда ты ниндзя, ты всегда настоящий, всегда готов к
                    действию и всегда в тени. Присоединяйтесь к нам и станьте частью этого удивительного мира!</p>
                <div class="login-buttons">
                    <form id="signInForm" method="post" action="${pageContext.request.contextPath}/ui/signIn">
                        <a class="login-link" href="#" onclick="document.getElementById('signInForm').submit(); return false;">Войдите</a>
                    </form>
                    <p class="or">или</p>
                    <form id="signUpForm" method="post" action="${pageContext.request.contextPath}/ui/signUp">
                        <a class="login-link" href="#" onclick="document.getElementById('signUpForm').submit(); return false;">Зарегистрируйтесь</a>
                    </form>
                </div>
            </div>
        </main>
        <footer>
            &copy; 2023 ninja-turtles, Inc.
        </footer>
    </c:otherwise>
</c:choose>
</body>
</html>