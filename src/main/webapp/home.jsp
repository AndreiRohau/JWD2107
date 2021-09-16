<%@ page language="java" contentType="text\html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<html>
<body>
<h1>Home</h1>
<a href="/main">[GET] go to main.jsp</a>

<p> Message from server (sessionScope.sessionParameter): ${sessionScope.sessionParameter}</p>
<p> Message from server (requestScope.result): ${requestScope.result}</p>
<p> Message from server (requestScope.msg): ${requestScope.msg}</p>

<form method="GET" action="/">
    <input type="text" name="msg" value=""/>
    <button type="submit">Submit</button>
</form>

</body>
</html>
