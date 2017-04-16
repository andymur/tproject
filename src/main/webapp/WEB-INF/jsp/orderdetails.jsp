<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                        <h2>ORDER<span class="color-bg">DETAILS</span></h2>
                    </div>

                    <div class="col-md-12">
                        <table class="table table-bordered table-striped table-advance table-hover">
                            <tbody>
                            <tr>
                                <th>ORDER ID</th>
                                <th>ORDER DATE</th>
                                <th>DELIVERY ADDRESS</th>
                                <th>PRODUCTS</th>
                                <th>ORDER STATUS</th>
                                <sec:authorize access="hasRole('ADMIN')">
                                <th>ACTION</th>
                                </sec:authorize>
                            </tr>
                                <tr>
                                    <td>
                                        ${order.orderId}
                                    </td>
                                    <td>
                                        ${order.orderDate}
                                    </td>
                                    <td>
                                        ${order.deliveryAddressDto}
                                    </td>
                                    <td>
                                        ${order.products}
                                    </td>
                                    <td>
                                        <div id="orderStatus" class="form-group">
                                            <label class="col-sm-2 control-label">Change status</label>
                                            <div id="sel-div" class="col-sm-10">
                                                <select id="orderStatusSelect" class="form-control m-bot15">
                                                    <option data-order-status=${order.orderStatusCode} selected >${order.orderStatusCode}</option>
                                                    <sec:authorize access="hasRole('ADMIN')">
                                                    <c:forEach var="status" items="${orderStatuses}">
                                                        <c:if test="${status != order.orderStatusCode}">
                                                        <option data-order-status=${status} >${status}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                    </sec:authorize>
                                                </select>
                                            </div>
                                        </div>
                                    </td>
                                    <sec:authorize access="hasRole('ADMIN')">
                                    <td>
                                        <button class="saveOrderStatus" value="${order.orderId}"  type="button">Save</button>
                                    </td>
                                    </sec:authorize>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="resources/orders.js"></script>
    </jsp:body>
</t:genericpage>