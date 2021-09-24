<!--
<%@ page language="java" contentType="text\html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
-->
<html>
<head>
    <style type="text/css">
        div form {
            display:inline-block
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <fmt:setLocale value="${sessionScope.locale}" />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en" var="en_btn" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru" var="ru_btn" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ch" var="ch_btn" />

    <fmt:message bundle="${loc}" key="local.main" var="main" />

    <fmt:message bundle="${loc}" key="local.login" var="login" />
    <fmt:message bundle="${loc}" key="local.password" var="password" />
    <fmt:message bundle="${loc}" key="local.hi" var="hi" />
    <fmt:message bundle="${loc}" key="local.bye" var="bye" />
    <fmt:message bundle="${loc}" key="local.name" var="name" />
    <fmt:message bundle="${loc}" key="local.surname" var="surname" />
    <fmt:message bundle="${loc}" key="local.belarus" var="belarus" />
    <fmt:message bundle="${loc}" key="local.potassium" var="potassium" />
    <fmt:message bundle="${loc}" key="local.china" var="china" />
    <fmt:message bundle="${loc}" key="key" var="key" />

    <title>
        <c:out value="${main}" />
    </title>
</head>
<body>
<h1>Main</h1>
<a href="/">[GET] go to home.jsp</a>
<br/>
<br/>
<p> Current locale=<c:out value="${sessionScope.locale}" /></p>
<br/>
<div>
    <form action="/" method="POST">
        <input type="hidden" name="command" value="locale" />
        <input type="hidden" name="locale" value="en" />
        <button type="submit">
            <c:out value="${en_btn}" />
        </button>
    </form>
    <form action="/" method="POST">
        <input type="hidden" name="command" value="locale" />
        <input type="hidden" name="locale" value="ru" />
        <button type="submit">
            <c:out value="${ru_btn}" />
        </button>
    </form>
    <form action="/" method="POST">
        <input type="hidden" name="command" value="locale" />
        <input type="hidden" name="locale" value="ch" />
        <button type="submit">
            <c:out value="${ch_btn}" />
        </button>
    </form>
</div>

<c:out value="${login}" /><br/>
<c:out value="${password}" /><br/>
<c:out value="${hi}" /><br/>
<c:out value="${bye}" /><br/>
<c:out value="${name}" /><br/>
<c:out value="${surname}" /><br/>
<c:out value="${belarus}" /><br/>
<c:out value="${potassium}" /><br/>
<c:out value="${china}" /><br/>
<c:out value="${key}" /><br/>


</body>
</html>
