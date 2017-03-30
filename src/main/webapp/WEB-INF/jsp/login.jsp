<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
      <h1>Welcome</h1>
    </jsp:attribute>
    <jsp:attribute name="footer">
      <p id="copyright">alex shop</p>
    </jsp:attribute>
    <jsp:body>
        <h3>Register Form</h3>

        <br/>
        <form action="register" method="get">
            Name:<input type="text" name="name"/><br/><br/>
            Email:<input type="text" name="email"/><br/><br/>
            Password:<input type="password" name="password"/><br/><br/>
            <input type="submit" value="register"/>"
        </form>
        <br/><br/>
    </jsp:body>
</t:genericpage>

