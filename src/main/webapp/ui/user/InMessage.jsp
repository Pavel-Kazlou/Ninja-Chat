<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Сообщения пользователя</title>
</head>
<body>
<jsp:include page="../header.jsp" />
<main>
    <div class="container">
        <h1>Сообщения пользователя</h1>
        <form method="get" action="${pageContext.request.contextPath}/api/message">
            <input type="submit" value="Обновить"/>
        </form>
        <c:forEach items="${userMessages}" var="message">
            <div class="message">
                <p><b>От кого:</b> ${message.from.userName}</p>
<%--                <p><b>Дата:</b> ${message.dateTime.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))}</p>--%>
                <p><b>Текст:</b> ${message.text}</p>
                <form method="post" action="${pageContext.request.contextPath}/ui/user/message">
                    <input type="hidden" name="to" value="${message.from.userName}"/>
                    <input type="submit" value="Ответить"/>
                </form>
                <form method="post" action="${pageContext.request.contextPath}/api/message/${message.id}">
                    <input type="hidden" name="_method" value="DELETE"/>
                    <input type="submit" value="Удалить"/>
                </form>
            </div>
        </c:forEach>
    </div>
</main>
<jsp:include page="../footer.jsp" />
</body>
</html>