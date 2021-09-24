<%@ page language="java" contentType="text\html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<h1>Home</h1>
<a href="/main">[GET] go to main.jsp</a>

<p> Message from server (sessionScope.sessionParameter): ${sessionScope.sessionParameter}</p>
<p> Message from server (param.result): ${param.result}</p>
<p> Message from server (param.msg): ${param.msg}</p>
<p> Message from server (requestScope.result): ${requestScope.result}</p>
<p> Message from server (requestScope.msg): ${requestScope.msg}</p>
<p> Message from server (c:out): <c:out value="${result}" /></p>
<h3>List userNames: </h3>
<ul><c:forEach var="userName" items="${userNames}">
        <li><c:out value="${userName}" /></li>
    </c:forEach></ul>
<h3> List coolie</h3>
<ul><c:forEach var="ckie" items="${cookie}">
        <li><c:out value="${ckie.value.name}" /> = <c:out value="${ckie.value.value}" /></li>
    </c:forEach></ul>
<h3> If statement</h3>
<c:if test="${isTrueParam}">
    <p>vizibl</p>
</c:if>
<c:if test="${isFalseParam == false}">
    <p>isFalseParam is vizibl</p>
</c:if>
<c:if test="${isFalseParam}">
    <p>INvizibl</p>
</c:if>

<h3> Choose statement STARTs</h3>
    <c:choose>
        <c:when test="${result eq '1'}">
            <p>equals to 1</p>
        </c:when>
        <c:when test="${result == '2'}">
            <p>equals to 2</p>
        </c:when>
        <c:when test="${result == 'asd'}">
            <p>equals to asdasdasdasd</p>
        </c:when>
        <c:otherwise>
            <p>Default behaviour</p>
        </c:otherwise>
    </c:choose>
<h3> Choose statement ENDs</h3>
<h3>Tag href</h3>
<a href='<c:url value="/main" />'>/main</a>
<c:if test="${result eq 'rdrctme'}">
    <c:redirect url="/?msg=redirectParamPassed" />
</c:if>

<br/>
<hr/>
<br/>
<form method="GET" action="/">
    <input type="text" name="msg" value=""/>
    <button type="submit">Submit</button>
</form>

<!-- need to rewrite this  -->
<form method="GET" action="/">
    <input type="hidden" name="command" value="getNamesAsJson"/>
    <button onclick="drawUsers()" type="button">Get Names As JSON</button>
</form>

</body>
</html>
