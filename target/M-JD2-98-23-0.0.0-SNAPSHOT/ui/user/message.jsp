<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Отправить сообщение</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ui/css/message.css">
</head>
<body>
<jsp:include page="../header.jsp" />

<c:if test="${not empty user}">
    <a href="${pageContext.request.contextPath}/ui/personal" class="back-button">Назад</a>
    <form method="post" action="${pageContext.request.contextPath}/api/message" class="message-form">
        <label for="to">Кому:</label>
        <select id="to" name="to" required>
            <option value="">Выберите получателя</option>
            <c:forEach items="${users}" var="recipient">
                <option value="${recipient.userName}"<c:if test="${recipient.userName == param.to}"> selected</c:if>>${recipient.userName}</option>
            </c:forEach>
        </select>

        <label for="text">Текст сообщения:</label>
        <textarea id="text" name="text" placeholder="Введите текст сообщения" required></textarea>

        <input type="submit" value="Отправить">
    </form>
</c:if>

<jsp:include page="../footer.jsp" />
</body>
</html>