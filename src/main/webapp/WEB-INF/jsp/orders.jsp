<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div id="wrapper">
            <div class="cart">
                <div class="container">
                    <div class="col-md-12 headlines">
                        <h2>ORD<span class="color-bg">ERS</span></h2>
                    </div>

                    <div class="col-md-12">
                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>ORDER ID</th>
                                <th>ORDER DATE</th>
                                <th>ORDER STATUS</th>
                                <th>PAYMENT TYPE</th>
                                <th>PAYMENT STATUS</th>
                                <th>DELIVERY TYPE</th>
                            </tr>
                            <c:set var="orders" scope="session" value="${orders}"/>
                            <c:set var="totalCount" scope="session" value="${fn:length(orders)}"/>
                            <c:set var="perPage" scope="session" value="${20}"/>
                            <c:set var="pageStart" value="${param.start}"/>
                            <c:if test="${empty pageStart or pageStart < 0}">
                                <c:set var="pageStart" value="0"/>
                            </c:if>
                            <c:if test="${totalCount < pageStart}">
                                <c:set var="pageStart" value="${pageStart - perPage}"/>
                            </c:if>
                            <c:forEach var="order" items="${orders}" begin="${pageStart}"
                                       end="${pageStart + perPage - 1}">
                                <tr>
                                    <td>
                                        <a href="orderdetails?orderId=${order.orderId}">${order.orderId}</a>
                                    </td>
                                    <td>
                                            ${order.orderDate}
                                    </td>
                                    <td>
                                            ${order.orderStatusCode}
                                    </td>
                                    <td>
                                            ${order.paymentType}
                                    </td>
                                    <td>
                                            ${order.paymentStatusCode}
                                    </td>
                                    <td>
                                            ${order.deliveryType}
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="text-center">
                        <ul class="pagination">
                            <li><a href="?start=${pageStart - perPage}">«</a></li>
                            <li><a href="#">${pageStart + 1}</a></li>
                            <li><a href="#">-</a></li>
                            <li><a href="#">${pageStart + perPage}</a></li>
                            <li><a href="?start=${pageStart + perPage}">»</a></li>
                        </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>